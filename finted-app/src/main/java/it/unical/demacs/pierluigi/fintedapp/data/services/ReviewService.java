package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.ReviewDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;

public interface ReviewService {
    ReviewDto save(ReviewDto review);

    void delete(Long id);

    List<ReviewDto> getUserReviews(Long userId) throws ElementNotFoundException;

    List<ReviewDto> getAuthorReviews(Long authorId) throws ElementNotFoundException;
}
