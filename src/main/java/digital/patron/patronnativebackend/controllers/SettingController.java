package digital.patron.patronnativebackend.controllers;

import digital.patron.patronnativebackend.integrate.dto.SettingLogoutDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SettingController {


    @PostMapping("/logout/success/endpoint")
    public ResponseEntity<String> logoutSuccess(){
        return ResponseEntity.status(HttpStatus.OK).body("logout-0713");
    }
}