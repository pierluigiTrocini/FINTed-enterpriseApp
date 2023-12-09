package it.unical.demacs.pierluigi.fintedapp.data.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import it.unical.demacs.pierluigi.fintedapp.data.dao.FavouriteDao;
import it.unical.demacs.pierluigi.fintedapp.data.dao.UserDao;
import it.unical.demacs.pierluigi.fintedapp.data.entities.Favourite;
import it.unical.demacs.pierluigi.fintedapp.data.services.FavouriteService;
import it.unical.demacs.pierluigi.fintedapp.dto.FavouriteDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavouriteServiceImpl implements FavouriteService{
    private final FavouriteDao favouriteDao;
    private final UserDao userDao;

    private final ModelMapper modelMapper;

    @Override
    public FavouriteDto save(FavouriteDto fav) {
        return modelMapper.map(favouriteDao.save(
            modelMapper.map(fav, Favourite.class)
        ), FavouriteDto.class);
    }

    @Override
    public void delete(Long id) {
        favouriteDao.deleteById(id);
    }

    @Override
    public List<FavouriteDto> getFollowers(Long userId) throws ElementNotFoundException {
        return favouriteDao.findAllByTarget(
            userDao.findById(userId).orElseThrow(() -> new ElementNotFoundException("user[target] not found"))
        ).stream()
        .map(fav -> modelMapper.map(fav, FavouriteDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public List<FavouriteDto> getFollow(Long userId) throws ElementNotFoundException {
        return favouriteDao.findAllByUser(
            userDao.findById(userId).orElseThrow(() -> new ElementNotFoundException("user[target] not found"))
        ).stream()
        .map(fav -> modelMapper.map(fav, FavouriteDto.class))
        .collect(Collectors.toList());
    }

}
