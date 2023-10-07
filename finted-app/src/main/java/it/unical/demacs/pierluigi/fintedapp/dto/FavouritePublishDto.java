package it.unical.demacs.pierluigi.fintedapp.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class FavouritePublishDto extends FavouriteDto {
    private UserDto user;

    private UserDto target;
}