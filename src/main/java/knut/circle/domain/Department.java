package knut.circle.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Department {

    public Department() {

    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", insertable = false, updatable = false)
    private Long id;
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Member> members = new ArrayList<>();
}
