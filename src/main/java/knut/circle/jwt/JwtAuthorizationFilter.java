package knut.circle.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import knut.circle.auth.PrincipalDetails;
import knut.circle.domain.Member;
import knut.circle.dto.Common.AuthVariable;
import knut.circle.repository.MemberRepository;
import knut.circle.repository.MemberRepositoryDataJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private MemberRepositoryDataJpa memberRepositoryDataJpa;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, MemberRepositoryDataJpa memberRepositoryDataJpa) {
        super(authenticationManager);
        this.memberRepositoryDataJpa = memberRepositoryDataJpa;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        super.doFilterInternal(request, response, chain);

        String jwtHeader = request.getHeader("Authorization");
        log.info("jwtHeader : {}", jwtHeader);

        if (jwtHeader == null || !jwtHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }
        String jwtToken = request.getHeader("Authorization").replace("Bearer ", "");
        String username = JWT.require(Algorithm.HMAC512(AuthVariable.AUTH_KEY)).build().verify(jwtToken).getClaim("username").asString();

        if (username != null) {
            Member findMember = memberRepositoryDataJpa.findByUsername(username);
            PrincipalDetails principalDetails = new PrincipalDetails(findMember);

            Authentication authentication
                    = new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        }
    }
}
