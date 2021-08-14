package knut.circle.controller;

import knut.circle.dto.CircleQueryDto;
import knut.circle.service.CircleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/knut")
public class IndexController {
    private final CircleService circleService;

    @GetMapping("/mainPage")
    public List<CircleQueryDto> loadMainPage(){
        return circleService.findMainPageCircle();
    }

}
