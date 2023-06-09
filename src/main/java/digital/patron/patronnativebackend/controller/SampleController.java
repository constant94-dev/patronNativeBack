package digital.patron.patronnativebackend.controller;

import digital.patron.patronnativebackend.dto.SampleHomeDto;
import digital.patron.patronnativebackend.dto.SampleTestDto;
import digital.patron.patronnativebackend.entitry.SampleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SampleController {

    @PostMapping("/home")
    public SampleTestDto main() {
        log.info("client 에서 요청이 정상적으로 들어왔습니다.");
        SampleTestDto sampleTestDto = new SampleTestDto("fdfd");

        return sampleTestDto;
    }
}
