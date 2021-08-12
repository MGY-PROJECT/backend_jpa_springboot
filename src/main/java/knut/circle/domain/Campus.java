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
@NoArgsConstructor
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campus_id")
    private Long id;

    @NotNull
    @Column(unique = true , updatable = false)
    private String name;

    @OneToMany(mappedBy = "campus")
    List<Circle> circles = new ArrayList<>();

    public Campus(@NotNull String name) {
        this.name = name;
    }
}
