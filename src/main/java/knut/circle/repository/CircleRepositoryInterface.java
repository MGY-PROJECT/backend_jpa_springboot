package knut.circle.repository;

import knut.circle.domain.Circle;
import knut.circle.domain.Department;
import knut.circle.dto.CircleQueryDto;

import java.util.List;

public interface CircleRepositoryInterface {
    public List<CircleQueryDto> findIndexCircle();
}
