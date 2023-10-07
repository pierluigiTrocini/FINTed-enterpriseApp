package it.unical.demacs.pierluigi.fintedapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CredentialsDto {
    
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String username;

}
