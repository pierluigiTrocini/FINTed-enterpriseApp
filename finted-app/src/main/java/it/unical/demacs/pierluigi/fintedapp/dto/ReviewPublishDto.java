package it.unical.demacs.pierluigi.fintedapp.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class ReviewPublishDto extends ReviewDto {
    private UserBasicInfoDto author;

    private UserDto user;

    private Date publishDate;

    @NotBlank
    private String content;
}
