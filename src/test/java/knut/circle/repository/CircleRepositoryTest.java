package knut.circle.repository;

import knut.circle.dto.CircleQueryDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class) // 완전히 스프링이랑 합쳐서 테스트
@SpringBootTest
@Transactional
class CircleRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CircleRepository repository;

    @Test
    public void 전체_동아리_조회() throws Exception{
        //given

        //when

        //then
        List<CircleQueryDto> indexCircle = repository.findIndexCircle();
        indexCircle.stream().forEach((s) -> System.out.println(s));
    }
}