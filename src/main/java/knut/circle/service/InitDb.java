package knut.circle.service;

import knut.circle.domain.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;


    @PostConstruct
    public void init(){
        initService.dbInit1();
    }


    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;

        public void dbInit1(){
            Department[] arr = {
                    new Department("기계자동차항공공학부"),
                    new Department("기계공학전공"),
                    new Department("자동차공학전공"),
                    new Department("항공기계설계전공"),
                    new Department("전자전기공학부"),
                    new Department("전기공학전공"),
                    new Department("전자공학과"),
                    new Department("의료IT공학전공"),
                    new Department("컴퓨터학부"),
                    new Department("컴퓨터공학전공"),
                    new Department("AI로봇공학과"),
                    new Department("바이오메디컬융합학과"),
                    new Department("소프트웨어전공"),

                    new Department("건설환경도시교통공학부"),
                    new Department("사회기반공학전공"),
                    new Department("환경공학전공"),
                    new Department("응용화학에너지공합부"),
                    new Department("화공생물공학전공"),
                    new Department("에너지소재공학전공"),
                    new Department("나노화학소재공학전공"),
                    new Department("산업경영안전공학부"),
                    new Department("산업경영공학전공"),
                    new Department("안전공학전공"),
                    new Department("건축학부"),
                    new Department("건축공학전공"),
                    new Department("건축학전공"),
                    new Department("디자인학부"),
                    new Department("산업디자인전공"),
                    new Department("커뮤니케이션디자인전공"),

                    new Department("글로벌어문학부"),
                    new Department("영어영문학전공"),
                    new Department("비즈니스영어전공"),
                    new Department("중국어전공"),
                    new Department("한국어문학전공"),
                    new Department("행정학부"),
                    new Department("행정학전공"),
                    new Department("행정정보학전공"),
                    new Department("경영통상복지학부"),
                    new Department("경영학전공"),
                    new Department("융합경영전공"),
                    new Department("국제통상전공"),
                    new Department("사회복지학전공"),
                    new Department("음악학과"),
                    new Department("스포츠학부"),
                    new Department("스포츠의학전공"),
                    new Department("스포츠산업학전공"),
                    new Department("항공서비스학과"),
                    new Department("항공운항학과"),
                    new Department("유아교육학과"),
                    new Department("미디어컨텐츠학과"),

                    new Department("간호학과"),
                    new Department("식품생명학부"),
                    new Department("식품공학전공"),
                    new Department("식품영양학전공"),
                    new Department("생명공학전공"),
                    new Department("물리치료학과"),
                    new Department("응급구조학과"),
                    new Department("유아특수교육학과"),
                    new Department("IT응용융합학과"),

                    new Department("철도경영.물류.데이터사이언스학부"),
                    new Department("철도경영물류학전공"),
                    new Department("데이터사이언스전공"),
                    new Department("철도공학부"),
                    new Department("철도운전시스템전공"),
                    new Department("철도차량시스템전공"),
                    new Department("철도인프라시스템공학전공"),
                    new Department("철도전기전자전공"),

                    new Department("스마트전기에너지공학과"),
                    new Department("건설환경융합공학과"),
                    new Department("안전융합공학과"),
                    new Department("스포츠복지학과"),
                    new Department("스마트철도교통공학과"),
                    new Department("복지경영학과"),

                    new Department("교양학부"),
                    new Department("자유전공학부"),
                    new Department("창의융합학부")
            };
            Arrays.stream(arr).forEach((e) -> em.persist(e));
            em.flush();
        }

        public void dbInit2(){

        }
    }
}
