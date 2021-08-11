package knut.circle.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", insertable = false, updatable = false)
    private Long id;
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Member> members = new ArrayList<>();
}
