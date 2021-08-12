package knut.circle.repository;

import knut.circle.domain.Department;
import knut.circle.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DepartmentRepository implements DepartmentRepositoryInterface{

    @PersistenceContext
    private EntityManager em; // 생성자로 받아도 됨.

    public Department findOne(Long id){
        Department findDept = em.find(Department.class, id);
        return findDept;
    }
}
