package knut.circle.repository;

import knut.circle.domain.Circle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CircleRepository implements CircleRepositoryInterface{

    private EntityManager em;

    @Override
    public Circle findAll(Long id) {
        return null;
    }
}
