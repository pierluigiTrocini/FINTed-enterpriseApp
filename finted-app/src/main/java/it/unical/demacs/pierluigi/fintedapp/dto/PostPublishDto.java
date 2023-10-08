package it.unical.demacs.pierluigi.fintedapp.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class PostPublishDto extends PostDto {
    private UserDto seller;

    private Date purchaseDate;

    private Date publishDate;
    
    private List<ImageDto> postImages;
}