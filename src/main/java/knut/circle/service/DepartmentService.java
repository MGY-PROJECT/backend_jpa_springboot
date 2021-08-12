package knut.circle.service;

import knut.circle.domain.Department;
import knut.circle.repository.DepartmentRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepositoryInterface departmentRepository;

    public Department findDept(Long id){
        Department findDept = departmentRepository.findOne(id);
        return findDept;
    }
}
