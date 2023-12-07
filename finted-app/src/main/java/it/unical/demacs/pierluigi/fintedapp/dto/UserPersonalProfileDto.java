package it.unical.demacs.pierluigi.fintedapp.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserPersonalProfileDto extends UserProfileDto{

    private List<ReviewDto> receivedReviews;

    private List<FavouriteDto> userLiked;

    private List<OfferDto> offersPublished;
}
