package it.unical.demacs.pierluigi.fintedapp.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class PostDto {
    private Long id;

    private UserDto seller;

    private String title;

    private Long startingPrice;

    private String postImage;

    private Date publish_date;
   
    private UserDto buyer;
}
