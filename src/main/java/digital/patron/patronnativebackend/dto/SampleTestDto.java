package digital.patron.patronnativebackend.dto;

import lombok.Getter;

@Getter
public class SampleTestDto {

    String test;

    public SampleTestDto(
            String test
    ) {
        this.test = test;
    }

}
