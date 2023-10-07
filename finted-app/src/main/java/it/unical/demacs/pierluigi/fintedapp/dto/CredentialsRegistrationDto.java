package it.unical.demacs.pierluigi.fintedapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class CredentialsRegistrationDto extends CredentialsDto{
    
    @NotBlank
    @Min(value = 8)
    private String password;

}
