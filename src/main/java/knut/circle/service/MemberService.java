package knut.circle.service;

import knut.circle.domain.Member;
import knut.circle.dto.CreateMemberRequest;
import knut.circle.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long saveMember(Member member){
        memberRepository.save(member);
        return member.getId();
    }
}
