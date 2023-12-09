package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.FavouriteDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;

public interface FavouriteService {
    FavouriteDto save(FavouriteDto fav);

    void delete(Long id);

    List<FavouriteDto> getFollowers(Long userId) throws ElementNotFoundException;

    List<FavouriteDto> getFollow(Long userId) throws ElementNotFoundException;

}
