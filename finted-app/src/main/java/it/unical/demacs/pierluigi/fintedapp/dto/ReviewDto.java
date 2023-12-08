package it.unical.demacs.pierluigi.fintedapp.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ReviewDto {
    private Long id;

    @NotNull
    private UserDto author;

    @NotNull
    private UserDto user;

    @NotEmpty
    private Date publishDate;

    @NotEmpty
    private String content;
}
