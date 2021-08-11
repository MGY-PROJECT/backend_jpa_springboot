package knut.circle.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import knut.circle.auth.PrincipalDetails;
import knut.circle.domain.Member;
import knut.circle.dto.Common.AuthVariable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info("============================================");
        log.info("JwtAuthenticationFilter 필터 실행중 로그인 시도");
        log.info("============================================");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Member member = objectMapper.readValue(request.getInputStream(), Member.class);
            log.info("=========={}=========", member);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword());


            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

            log.info("============================================");
            log.info("회원가입을 시도한 멤버객체 (로그인 성공) = {}", principal.getMember());

            return authentication;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("========================");
        log.info("=========인증 성공========");
        log.info("========================");

        PrincipalDetails principal = (PrincipalDetails) authResult.getPrincipal();

        String jwtToken = JWT.create()
                .withSubject("knut")
                .withExpiresAt(new Date(System.currentTimeMillis()+(AuthVariable.AUTH_TIME)))
                .withClaim("id", principal.getMember().getId())
                .withClaim("username", principal.getMember().getUsername())
                .sign(Algorithm.HMAC512(AuthVariable.AUTH_KEY));


        response.addHeader("Authorization", "Bearer "+jwtToken); //담기는 형식
    }

}
