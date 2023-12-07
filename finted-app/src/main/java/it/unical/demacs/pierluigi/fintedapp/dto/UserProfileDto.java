package it.unical.demacs.pierluigi.fintedapp.dto;

import java.sql.Date;
import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.data.entities.Address;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserProfileDto extends UserDto{

    private String credentialsEmail;

    private Address address;

    private Date registrationDate;

    private List<PostDto> publishedPosts;

    private List<ReviewDto> receivedReviews;

    private List<FavouriteDto> receivedLikes;
}
