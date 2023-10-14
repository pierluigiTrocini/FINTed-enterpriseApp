package it.unical.demacs.pierluigi.fintedapp.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class UserBasicInfoDto extends UserDto {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private Date registrationDate;
}
