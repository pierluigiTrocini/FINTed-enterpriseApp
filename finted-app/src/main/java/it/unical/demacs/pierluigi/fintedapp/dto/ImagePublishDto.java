package it.unical.demacs.pierluigi.fintedapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ImagePublishDto extends ImageDto{
    @NotNull
    private Long postId;

    @NotNull
    private String data;
}
