package knut.circle.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true, length = 7)
    @NotNull
    private String username; // 로그인 id

    //    @Column(nullable = false)
    // 제약조건만 설정해주고 유효성 검사는 해주지 않음.
    @NotNull
    private String name; // 사용자 이름

    @NotNull
    private String password; // 비밀번호

    @NotNull
    private String email; // 사용자 이메일

    @Embedded
    private CommonTime commonTime;

    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus = ActiveStatus.ENABLE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<JoinCircle> joinCircles = new ArrayList<>();

    private String roles;

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public void addDepartment(Department department){
        if(department.getMembers().contains(this)){

        }else{
            this.department = department;
            department.getMembers().add(this);
        }
    }



}
