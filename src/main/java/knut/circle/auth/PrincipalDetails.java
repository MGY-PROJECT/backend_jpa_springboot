package knut.circle.auth;

import knut.circle.domain.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


@Getter
@Setter
public class PrincipalDetails implements UserDetails {

    private Member member;

    public PrincipalDetails(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        member.getRoleList().forEach(r-> {
            System.out.println("Element = " + r);
            authorities.add(()->r);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //계정이 만료되지는 않았는지
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //계정이 잠겨있지는 않은지
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //계정의 패스워드가 만료되었는지
    }

    @Override
    public boolean isEnabled() {
        return true; //계정이 사용가능한 계정인지.
    }
}
