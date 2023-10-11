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

import it.unical.demacs.pierluigi.fintedapp.data.services.OfferService;
import it.unical.demacs.pierluigi.fintedapp.dto.OfferDto;
import it.unical.demacs.pierluigi.fintedapp.dto.OfferPublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class OfferController {
    
    private final OfferService offerService;

    @PostMapping("/")
    public ResponseEntity<OfferDto> save(@RequestBody OfferPublishDto offer) throws NullFieldException, ElementNotFoundException{
        return ResponseEntity.ok(offerService.save(offer));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws NullFieldException, ElementNotFoundException{
        offerService.delete(id);
    }

    @GetMapping("/post/{post-id}")
    public ResponseEntity<List<OfferDto>> getPostOffers(@PathVariable("post-id") Long postId){
        return ResponseEntity.ok(offerService.getPostOffers(postId));
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<OfferDto>> getUserOffers(@PathVariable("user-id") Long userId){
        return ResponseEntity.ok(offerService.getPostOffers(userId));
    }

}
