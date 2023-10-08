package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.FavouriteDto;
import it.unical.demacs.pierluigi.fintedapp.dto.FavouritePublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;

public interface FavouriteService {
    FavouriteDto save(FavouritePublishDto like) throws NullFieldException, ElementNotFoundException;

    void delete(Long id) throws NullFieldException, ElementNotFoundException;

    List<FavouriteDto> getAll(Long userId) throws ElementNotFoundException;
}
