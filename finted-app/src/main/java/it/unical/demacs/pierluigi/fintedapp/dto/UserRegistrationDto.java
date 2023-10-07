package it.unical.demacs.pierluigi.fintedapp.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class UserRegistrationDto extends UserBasicInfoDto {
    private AddressDto address;

    private CredentialsRegistrationDto credentials;
}
