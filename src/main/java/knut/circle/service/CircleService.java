package knut.circle.service;

import knut.circle.dto.CircleQueryDto;
import knut.circle.repository.CircleRepository;
import knut.circle.repository.CircleRepositoryInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CircleService {
    private final CircleRepositoryInterface circleRepository;

    public List<CircleQueryDto> findMainPageCircle(){
        return circleRepository.findIndexCircle();
    }
}
