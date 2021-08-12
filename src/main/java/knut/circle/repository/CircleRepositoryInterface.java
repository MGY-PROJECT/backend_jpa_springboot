package knut.circle.repository;

import knut.circle.domain.Circle;
import knut.circle.domain.Department;

public interface CircleRepositoryInterface {
    public Circle findAll(Long id);
}
