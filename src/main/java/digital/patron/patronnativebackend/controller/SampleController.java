package digital.patron.patronnativebackend.controller;

import digital.patron.patronnativebackend.entitry.SampleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

    @PostMapping("/home/main")
    public SampleEntity main(@RequestBody SampleEntity sampleEntity) {
        log.info("client 에서 들어온 code: " + sampleEntity.getCode());

        return sampleEntity;
    }
}
