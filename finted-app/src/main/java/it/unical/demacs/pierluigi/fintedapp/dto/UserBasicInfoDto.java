package it.unical.demacs.pierluigi.fintedapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class UserBasicInfoDto extends UserDto {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
}
