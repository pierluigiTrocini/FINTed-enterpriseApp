package it.unical.demacs.pierluigi.fintedapp.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ReviewDto {
    private Long id;

    private UserDto author;

    private UserDto user;

    private Date publishDate;

    private String content;
}
