package digital.patron.patronnativebackend.controllers;

import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import digital.patron.patronnativebackend.exhibition.service.ExhibitionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HomeController {
    private static final String MAIN_EXHIBITION = "메인전시";

    private final ExhibitionService exhibitionService;


    @GetMapping("/home")
    public void home() {
        log.info("client 에서 요청이 정상적으로 들어왔습니다.");

        List<Exhibition> mainExhibition = exhibitionService.findExhibitionsByGroupName(MAIN_EXHIBITION, "kr", "ko");
    }
}