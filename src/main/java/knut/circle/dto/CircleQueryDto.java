package knut.circle.dto;


import knut.circle.domain.CampusEnum;
import lombok.Data;

@Data
public class CircleQueryDto {
    private Long circleId;
    private String circleName;
    private CampusEnum campus;
    private String profile;
    private String background;
    private String classification;

    public CircleQueryDto(Long circleId,
                          String circleName,
                          CampusEnum campus,
                          String profile,
                          String background,
                          String classification) {

        this.circleId = circleId;
        this.circleName = circleName;
        this.campus = campus;
        this.profile = profile;
        this.background = background;
        this.classification = classification;
    }
}
