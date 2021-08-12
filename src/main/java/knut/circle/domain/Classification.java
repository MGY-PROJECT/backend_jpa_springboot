package knut.circle.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Classification {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classification_id")
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "classification", cascade = CascadeType.PERSIST)
    List<Circle> circles = new ArrayList<>();
}
