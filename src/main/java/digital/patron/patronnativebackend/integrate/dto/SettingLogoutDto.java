package digital.patron.patronnativebackend.integrate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SettingLogoutDto {
    private Long id;
    private String name;

    protected SettingLogoutDto(){}
}
