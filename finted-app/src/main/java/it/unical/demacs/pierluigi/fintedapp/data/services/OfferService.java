package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.OfferDto;
import it.unical.demacs.pierluigi.fintedapp.dto.OfferPublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;

public interface OfferService {
    OfferDto save(OfferPublishDto offer) throws NullFieldException, ElementNotFoundException;

    void delete(Long id) throws NullFieldException, ElementNotFoundException;

    List<OfferDto> getAll(Long id);
}
