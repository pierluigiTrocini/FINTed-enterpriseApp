package it.unical.demacs.pierluigi.fintedapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unical.demacs.pierluigi.fintedapp.data.services.ImageService;
import it.unical.demacs.pierluigi.fintedapp.dto.ImageDto;
import it.unical.demacs.pierluigi.fintedapp.dto.ImagePublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.ImagesLimitExceededException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/")
    public ResponseEntity<ImageDto> save(@RequestBody ImagePublishDto image) throws NullFieldException, ElementNotFoundException, ImagesLimitExceededException{
        return ResponseEntity.ok(imageService.save(image));
    }

    @DeleteMapping("/post/{post-id}")
    public void delete(@PathVariable("post-id") Long postId) throws NullFieldException, ElementNotFoundException{
        imageService.delete(postId);
    }

    @GetMapping("/{post-id}")
    public ResponseEntity<ImageDto> get(@PathVariable("post-id") Long postId) throws ElementNotFoundException, NullFieldException{
        return ResponseEntity.ok(imageService.getAll(postId));
    }
    
}
