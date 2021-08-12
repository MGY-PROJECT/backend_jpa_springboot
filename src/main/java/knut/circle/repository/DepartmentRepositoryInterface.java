package knut.circle.repository;

import knut.circle.domain.Department;

public interface DepartmentRepositoryInterface {
    public Department findOne(Long id);
}
