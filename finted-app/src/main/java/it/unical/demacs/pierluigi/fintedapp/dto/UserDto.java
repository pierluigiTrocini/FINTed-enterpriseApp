package it.unical.demacs.pierluigi.fintedapp.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private Date registration_date;
}
