package it.unical.demacs.pierluigi.fintedapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UserDto {
    @NotBlank
    private Long id;    
}