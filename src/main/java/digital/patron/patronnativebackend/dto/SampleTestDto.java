package digital.patron.patronnativebackend.dto;

import lombok.Getter;

@Getter
public class SampleTestDto {

    String title;

    public SampleTestDto(
            String title
    ) {
        this.title = title;
    }

}
