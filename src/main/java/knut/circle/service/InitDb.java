package knut.circle.service;

import knut.circle.domain.*;
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
        initService.dbInit2();
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
            Classification health = new Classification("체육");
            Classification music = new Classification("음악");
            Classification volunteer = new Classification("봉사");
            Classification religion = new Classification("종교");
            Classification study = new Classification("학술");
            Classification art = new Classification("문예");

            CommonTime commonTime = new CommonTime();

            Circle kaka = new Circle("카카", CampusEnum.C, null, null,commonTime);
            kaka.addClassification(health);
            Circle o2 = new Circle("오투", CampusEnum.C, null, null,commonTime);
            o2.addClassification(health);
            Circle hangkok = new Circle("행콕", CampusEnum.C, null, null,commonTime);
            hangkok.addClassification(health);
            Circle perfect = new Circle("퍼펙트", CampusEnum.C, null, null,commonTime);
            perfect.addClassification(health);
            Circle wekid = new Circle("위키드", CampusEnum.C, null, null,commonTime);
            wekid.addClassification(health);
            Circle mountain = new Circle("산악부", CampusEnum.C, null, null,commonTime);
            mountain.addClassification(health);
            Circle passion = new Circle("열정", CampusEnum.C, null, null,commonTime);
            passion.addClassification(health);
            Circle split = new Circle("스플릿", CampusEnum.C, null, null,commonTime);
            split.addClassification(health);
            Circle kookwon = new Circle("국원검우회", CampusEnum.C, null, null,commonTime);
            kookwon.addClassification(health);
            Circle highrun = new Circle("하이런", CampusEnum.C, null, null,commonTime);
            highrun.addClassification(health);
            Circle best5 = new Circle("best5", CampusEnum.C, null, null,commonTime);
            best5.addClassification(health);
            Circle normal = new Circle("보통사람들", CampusEnum.C, null, null,commonTime);
            normal.addClassification(health);

            Circle finale = new Circle("피날레", CampusEnum.C, null, null,commonTime);
            finale.addClassification(music);
            Circle bital = new Circle("바이탈사인", CampusEnum.C, null, null,commonTime);
            bital.addClassification(music);
            Circle poseidon = new Circle("포세이돈", CampusEnum.C, null, null,commonTime);
            poseidon.addClassification(music);
            Circle soridam = new Circle("소리담", CampusEnum.C, null, null,commonTime);
            soridam.addClassification(music);
            Circle sinmoongo = new Circle("신문고", CampusEnum.C, null, null,commonTime);
            sinmoongo.addClassification(music);
            Circle sixline = new Circle("식스라인", CampusEnum.C, null, null,commonTime);
            sixline.addClassification(music);

            Circle police = new Circle("폴리스", CampusEnum.C, null, null,commonTime);
            police.addClassification(volunteer);
            Circle youthJC = new Circle("YouthJC", CampusEnum.C, null, null,commonTime);
            youthJC.addClassification(volunteer);
            Circle leo = new Circle("LEO", CampusEnum.C, null, null,commonTime);
            leo.addClassification(volunteer);
            Circle knutunion = new Circle("KNUT해외봉사연합", CampusEnum.C, null, null,commonTime);
            knutunion.addClassification(volunteer);
            Circle friends = new Circle("러빙프렌즈", CampusEnum.C, null, null,commonTime);
            friends.addClassification(volunteer);

            Circle ccc = new Circle("CCC", CampusEnum.C, null, null,commonTime);
            ccc.addClassification(religion);
            Circle bangjoo = new Circle("방주짓는사람들", CampusEnum.C, null, null,commonTime);
            bangjoo.addClassification(religion);

            Circle egao = new Circle("에가오", CampusEnum.C, null, null,commonTime);
            egao.addClassification(study);
            Circle unipeace = new Circle("유니피스", CampusEnum.C, null, null,commonTime);
            unipeace.addClassification(study);

            Circle love = new Circle("사랑방극예술연구회", CampusEnum.C, null, null,commonTime);
            love.addClassification(art);
            Circle shuter = new Circle("셔터스네이크", CampusEnum.C, null, null,commonTime);
            shuter.addClassification(art);


            Circle buzzer = new Circle("버저비터", CampusEnum.J, null, null,commonTime);
            buzzer.addClassification(health);
            Circle go = new Circle("GO유도", CampusEnum.J, null, null,commonTime);
            go.addClassification(health);

            Circle stop = new Circle("절주", CampusEnum.J, null, null,commonTime);
            stop.addClassification(volunteer);

            Circle pax = new Circle("PAX", CampusEnum.J, null, null,commonTime);
            pax.addClassification(religion);

            Circle swings = new Circle("스윙스", CampusEnum.E, null, null,commonTime);
            swings.addClassification(health);

            Circle apex = new Circle("APEX", CampusEnum.E, null, null,commonTime);
            apex.addClassification(music);

            Circle number = new Circle("1067", CampusEnum.E, null, null,commonTime);
            number.addClassification(study);

            em.persist(health);
            em.persist(study);
            em.persist(art);
            em.persist(religion);
            em.persist(volunteer);
            em.persist(music);

            em.flush();


        }
    }
}
