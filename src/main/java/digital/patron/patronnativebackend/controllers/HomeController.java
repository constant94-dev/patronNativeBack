package digital.patron.patronnativebackend.controllers;

import digital.patron.patronnativebackend.exhibition.domain.Exhibition;
import digital.patron.patronnativebackend.exhibition.dto.ExhibitionDto;
import digital.patron.patronnativebackend.exhibition.service.ExhibitionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HomeController {
    private static final String MAIN_EXHIBITION = "메인전시";

    private final ExhibitionService exhibitionService;


    @GetMapping("/home")
    public ResponseEntity<?> home() {
        log.info("client 에서 요청이 정상적으로 들어왔습니다.");

        List<Exhibition> mainExhibition = exhibitionService.findExhibitionsByGroupName(MAIN_EXHIBITION, "en", "en");
        if (mainExhibition.size() != 0) {
            log.info(mainExhibition.stream().map(m -> m.getId()).collect(Collectors.toList()).toString());
            System.out.println("값이 존재한다: " + mainExhibition.size());
        } else {
            System.out.println("값이 없습니다.");
        }
        ExhibitionDto exhibitionDto = new ExhibitionDto(mainExhibition.stream().map(e -> e.getId()).collect(Collectors.toList()),
                mainExhibition.stream().map(e -> e.getExhibitionDetails().stream().filter(d->d.getLanguage().equals("en")).findFirst().get().getName()).collect(Collectors.toList()));
        return ResponseEntity.status(HttpStatus.OK).body(exhibitionDto);
    }
}