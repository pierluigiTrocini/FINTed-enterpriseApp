package it.unical.demacs.pierluigi.fintedapp.dto;

import java.sql.Date;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class OfferPublishDto extends OfferDto {
    
    private PostDto post;

    private UserDto user;

    private Date publishDate;

    @PositiveOrZero
    private Long offer;

}