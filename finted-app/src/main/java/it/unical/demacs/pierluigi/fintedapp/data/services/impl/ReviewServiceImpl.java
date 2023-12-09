package it.unical.demacs.pierluigi.fintedapp.data.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import it.unical.demacs.pierluigi.fintedapp.data.dao.ReviewDao;
import it.unical.demacs.pierluigi.fintedapp.data.dao.UserDao;
import it.unical.demacs.pierluigi.fintedapp.data.entities.Review;
import it.unical.demacs.pierluigi.fintedapp.data.services.ReviewService;
import it.unical.demacs.pierluigi.fintedapp.dto.ReviewDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewDao reviewDao;
    private final UserDao userDao;

    private final ModelMapper modelMapper;

    @Override
    public ReviewDto save(ReviewDto review) {
        return modelMapper.map(
            modelMapper.map(review, Review.class), ReviewDto.class);
    }

    @Override
    public void delete(Long id) {
        reviewDao.deleteById(id);
    }

    @Override
    public List<ReviewDto> getUserReviews(Long userId) throws ElementNotFoundException {
        return reviewDao.findAllByUser(
            userDao.findById(userId).orElseThrow(() -> new ElementNotFoundException("user not found"))
        ).stream()
        .map(review -> modelMapper.map(review, ReviewDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> getAuthorReviews(Long authorId) throws ElementNotFoundException {
        return reviewDao.findAllByAuthor(
            userDao.findById(authorId).orElseThrow(() -> new ElementNotFoundException("user not found"))
        ).stream()
        .map(review -> modelMapper.map(review, ReviewDto.class))
        .collect(Collectors.toList());
    }
}
