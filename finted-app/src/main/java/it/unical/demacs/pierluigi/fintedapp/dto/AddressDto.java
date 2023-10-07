package it.unical.demacs.pierluigi.fintedapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class AddressDto {
    
    @NotBlank
    private String route;

    @NotBlank
    private String number;

    @NotBlank
    private String city;
}
