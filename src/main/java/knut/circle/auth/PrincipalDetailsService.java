package knut.circle.auth;

import knut.circle.domain.Member;
import knut.circle.repository.MemberRepositoryDataJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepositoryDataJpa memberRepositoryDataJpa;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member findMember = memberRepositoryDataJpa.findByUsername(username);
        log.info("============ load User By UserName ============"); //실행되는지 확인
        return new PrincipalDetails(findMember);
    }
}
