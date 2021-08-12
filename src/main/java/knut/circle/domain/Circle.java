package knut.circle.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Circle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "circle_id")
    private Long id;

    @NotNull
    @Column(insertable = false, updatable = false)
    private String name;

//     어쩔 수 없는 반정규화 ㅅㄱㅇ

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "campus_id")
//    private Campus campus;

    @Enumerated(EnumType.STRING)
    @Column(length = 2, updatable = false)
    private CampusEnum campus;

    @OneToMany(mappedBy = "circle")
    private List<JoinCircle> joinCircles = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classification_id")
    private Classification classification;




    public void addClassification(Classification classification){
        if(classification.getCircles().contains(this)){
        }else{
            classification.getCircles().add(this);
            this.classification = classification;
        }
    }

//    public void addCampus(Campus campus){
//        if(campus.getCircles().contains(this)){
//        }else{
//            campus.getCircles().add(this);
//            this.campus = campus;
//        }
//    }
}
