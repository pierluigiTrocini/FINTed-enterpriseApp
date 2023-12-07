package it.unical.demacs.pierluigi.fintedapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class FavouriteDto {
    private Long id;

    private UserDto user;

    private UserDto target;
}