package knut.circle.repository;

import knut.circle.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoryDataJpa extends JpaRepository<Member, Long> {
    public Member findByUsername(String username);
}
