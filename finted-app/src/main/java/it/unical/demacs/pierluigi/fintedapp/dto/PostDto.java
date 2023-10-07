package it.unical.demacs.pierluigi.fintedapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class PostDto {
    private Long id;

    @NotNull
    private String title;

    @NotNull
    @PositiveOrZero
    private Long startingPrice;
}
