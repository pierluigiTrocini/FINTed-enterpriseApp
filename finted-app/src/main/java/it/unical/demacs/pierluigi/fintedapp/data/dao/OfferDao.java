package it.unical.demacs.pierluigi.fintedapp.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unical.demacs.pierluigi.fintedapp.data.entities.Offer;

public interface OfferDao extends JpaRepository<Offer, Long> {
    
}