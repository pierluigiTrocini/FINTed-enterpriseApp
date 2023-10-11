package it.unical.demacs.pierluigi.fintedapp.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unical.demacs.pierluigi.fintedapp.data.entities.Offer;

public interface OfferDao extends JpaRepository<Offer, Long> {
    
    List<Offer> findAllByPostId(Long postId);

    List<Offer> findAllByUserId(Long userID);

}