package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.FavouriteDto;

public interface FavouriteService {
    FavouriteDto save(FavouriteDto fav);

    void delete(Long id);

    List<FavouriteDto> getFollowers(Long userId);

    List<FavouriteDto> getFollow(Long userId);

}
