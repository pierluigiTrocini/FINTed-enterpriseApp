package it.unical.demacs.pierluigi.fintedapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class ImagePublishDto extends ImageDto{
    @NotNull
    private PostDto post;

    @NotNull
    private String data;
}
