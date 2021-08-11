package knut.circle.dto;

import knut.circle.domain.Department;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateMemberRequest {

    @NotEmpty(message = "아이디는 필수입니다.")
    private String username;
    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String password;

    @Email
    private String email;

    @NotEmpty(message = "이름은 필수입니다.")
    private String name;

    @NotNull
    private Long departmentId;
}
