package it.unical.demacs.pierluigi.fintedapp.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class UserProfileDto extends UserBasicInfoDto {
    private CredentialsDto credentials;

    private List<PostDto> publishedPosts;

    private List<ReviewDto> publishedReviews;

    private List<ReviewDto> receivedReviews;

    private List<FavouriteDto> userLiked;

    private List<FavouriteDto> receivedLikes;
    
    private List<OfferDto> offersPublished;
}