package knut.circle.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor//for init
public class Classification {

    public Classification(@NotNull String name) {
        this.name = name;
    }//for init

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classification_id")
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "classification", cascade = CascadeType.PERSIST)
    List<Circle> circles = new ArrayList<>();

}
