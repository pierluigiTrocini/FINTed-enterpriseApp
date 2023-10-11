package it.unical.demacs.pierluigi.fintedapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import it.unical.demacs.pierluigi.fintedapp.data.services.ReviewService;
import it.unical.demacs.pierluigi.fintedapp.dto.ReviewDto;
import it.unical.demacs.pierluigi.fintedapp.dto.ReviewPublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/")
    public ResponseEntity<ReviewDto> save(@RequestBody ReviewPublishDto like) throws ElementNotFoundException, NullFieldException{
        return ResponseEntity.ok(reviewService.save(like));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws NullFieldException, ElementNotFoundException{
        reviewService.delete(id);
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<List<ReviewDto>> getAll(@PathVariable("user-id") Long userId) throws ElementNotFoundException{
        return ResponseEntity.ok(reviewService.getAll(userId));
    }


}
