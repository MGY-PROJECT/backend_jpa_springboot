package knut.circle.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor //for init
@Slf4j
public class Circle {

    public Circle(@NotNull String name,
                  CampusEnum campus,
                  String background,
                  String profile,
                  CommonTime commonTime) {
        this.name = name;
        this.campus = campus;
        this.background = background;
        this.profile = profile;
        this.commonTime = commonTime;
    }// for init

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "circle_id")
    private Long id;

    @NotNull
    @Column(updatable = false)
    private String name;

    @Embedded
    private CommonTime commonTime; //동아리 창설 시각

//     어쩔 수 없는 반정규화 ㅅㄱㅇ

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "campus_id")
//    private Campus campus;

    @Enumerated(EnumType.STRING)
    @Column(length = 3)
    private CampusEnum campus;

    private String background; //path
    private String profile;    //path2

    @OneToMany(mappedBy = "circle")
    private List<JoinCircle> joinCircles = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classification_id")
    private Classification classification;



    public void addClassification(Classification classification){
        if(classification.getCircles().contains(this) && this.classification != null){
            log.info("실패");
        }else{
            log.info("성공");
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
