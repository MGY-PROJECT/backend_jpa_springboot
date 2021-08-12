package knut.circle.repository;

import knut.circle.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceProperty;

@Repository
public class MemberRepository implements MemberRepositoryInterface{

    @PersistenceContext
    private EntityManager em; // 생성자로 받아도 됨.

    public void save(Member member){
        em.persist(member);
    }

}
