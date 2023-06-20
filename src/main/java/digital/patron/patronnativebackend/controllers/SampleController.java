package digital.patron.patronnativebackend.controllers;

import digital.patron.patronnativebackend.networktest.NetworkTest0612;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SampleController {
    @GetMapping("/test")
    public NetworkTest0612 test() {
        log.info("클라이언트에서 요청이 정상적으로 들어왔다!!!!!!!!!!!!!!!!!!!");
        String title = "받아!!!!!!!!!!!!!!!!!!!!";
        NetworkTest0612 networkTest = new NetworkTest0612(title);

        return networkTest;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello!";
    }
}
