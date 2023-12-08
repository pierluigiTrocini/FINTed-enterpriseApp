package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.ReviewDto;

public interface ReviewService {
    ReviewDto save(ReviewDto review);

    void delete(Long id);

    List<ReviewDto> getAll(Long userId);
}
