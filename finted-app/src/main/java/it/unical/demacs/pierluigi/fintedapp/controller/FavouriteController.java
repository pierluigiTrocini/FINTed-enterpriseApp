package it.unical.demacs.pierluigi.fintedapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unical.demacs.pierluigi.fintedapp.data.services.FavouriteService;
import it.unical.demacs.pierluigi.fintedapp.dto.FavouriteDto;
import it.unical.demacs.pierluigi.fintedapp.dto.FavouritePublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/likes")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequiredArgsConstructor
public class FavouriteController {
    private final FavouriteService favouriteService;

    @PostMapping("/")
    public ResponseEntity<FavouriteDto> save(@RequestBody FavouritePublishDto like) throws NullFieldException, ElementNotFoundException{
        return ResponseEntity.ok(favouriteService.save(like));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws NullFieldException, ElementNotFoundException{
        favouriteService.delete(id);
    }

    @GetMapping("/followers/{user-id}")
    public ResponseEntity<List<FavouriteDto>> getFollowers(@PathVariable("user-id") Long userId) throws ElementNotFoundException{
        return ResponseEntity.ok(favouriteService.getMyFollowers(userId));
    }

    @GetMapping("/follow/{user-id}")
    public ResponseEntity<List<FavouriteDto>> getFollow(@PathVariable("user-id") Long userId) throws ElementNotFoundException{
        return ResponseEntity.ok(favouriteService.getFollow(userId));
    }
}
