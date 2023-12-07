package it.unical.demacs.pierluigi.fintedapp.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class OfferDto {
    private Long id;

    private PostDto postDto;

    private UserDto user;

    private Long offer;

    private Date publishDate;
}
