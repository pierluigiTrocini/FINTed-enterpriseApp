package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.ReviewDto;
import it.unical.demacs.pierluigi.fintedapp.dto.ReviewPublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;

public interface ReviewService {
    ReviewDto save(ReviewPublishDto review) throws ElementNotFoundException, NullFieldException;

    void delete(Long id) throws NullFieldException, ElementNotFoundException;

    List<ReviewDto> getAll(Long userId) throws ElementNotFoundException;
}
