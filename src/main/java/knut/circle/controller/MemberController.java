package knut.circle.controller;

import knut.circle.domain.Member;
import knut.circle.domain.CommonTime;
import knut.circle.dto.CreateMemberRequest;
import knut.circle.dto.CreateMemberResponse;
import knut.circle.service.DepartmentService;
import knut.circle.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final DepartmentService departmentService;
    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public CreateMemberResponse joinForm(@RequestBody @Valid CreateMemberRequest createMemberRequest, BindingResult result){
        if(result.hasErrors()){
            log.info("회원가입 중 발생한 오류. = {}", result.getAllErrors());
            return null;
        }

        log.info("======{}======",createMemberRequest);
        Member member = new Member();
        member.setUsername(createMemberRequest.getUsername());
        member.setName(createMemberRequest.getName());
        member.setPassword(bCryptPasswordEncoder.encode(createMemberRequest.getPassword()));
        member.setEmail(createMemberRequest.getEmail());
        member.addDepartment(departmentService.findDept(createMemberRequest.getDepartmentId()));
        member.setCommonTime(new CommonTime());
        member.setRoles("ROLE_USER");

        Long savedMemberId = memberService.saveMember(member);

        return new CreateMemberResponse(savedMemberId);
    }



}
