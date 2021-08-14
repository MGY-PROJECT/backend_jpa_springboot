package knut.circle.repository;

import knut.circle.domain.Circle;
import knut.circle.dto.CircleQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CircleRepository implements CircleRepositoryInterface {

    private final EntityManager em;

    @Override
    public List<CircleQueryDto> findIndexCircle() {
        List<CircleQueryDto> result = em.createQuery("select new knut.circle.dto.CircleQueryDto(c.id, c.name, c.campus, c.profile, c.background, f.name) " +
                        "from Circle c " +
                        "join c.classification f"
                        , CircleQueryDto.class)
                .getResultList();

        return result;
    }
}
