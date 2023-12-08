package it.unical.demacs.pierluigi.fintedapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserRegistrationDto extends UserDto {
    @NotEmpty
    private String credentialsEmail;
    
    @NotEmpty
    private String credentialsPassword;
    
    @NotEmpty
    private String addressRoute;
    
    @NotEmpty
    private String addressNumber;
    
    @NotEmpty
    private String addressCity;
    
}
