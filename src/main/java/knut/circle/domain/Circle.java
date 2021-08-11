package knut.circle.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Circle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "circle_id")
    private Long id;

    private String circleName;

    @OneToMany(mappedBy = "circle")
    private List<JoinCircle> joinCircles = new ArrayList<>();
}
