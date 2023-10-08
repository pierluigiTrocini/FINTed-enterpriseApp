package it.unical.demacs.pierluigi.fintedapp.data.services.Implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import it.unical.demacs.pierluigi.fintedapp.data.dao.FavouriteDao;
import it.unical.demacs.pierluigi.fintedapp.data.dao.UserDao;
import it.unical.demacs.pierluigi.fintedapp.data.entities.Favourite;
import it.unical.demacs.pierluigi.fintedapp.data.services.FavouriteService;
import it.unical.demacs.pierluigi.fintedapp.dto.FavouriteDto;
import it.unical.demacs.pierluigi.fintedapp.dto.FavouritePublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavouriteServiceImpl implements FavouriteService{
    private final FavouriteDao favouriteDao;
    private final UserDao userDao;

    private final ModelMapper modelMapper;
    
    @Override
    public FavouriteDto save(FavouritePublishDto like) throws NullFieldException, ElementNotFoundException {
        Favourite newFavourite = new Favourite();

        newFavourite.setUser( userDao.findById(like.getUser().getId()).orElseThrow(() -> new ElementNotFoundException("User not found")) );
        newFavourite.setTarget( userDao.findById( like.getTarget().getId()).orElseThrow(() -> new ElementNotFoundException("User not found")) );
        
        return modelMapper.map( favouriteDao.save(newFavourite), FavouritePublishDto.class );
    }

    @Override
    public void delete(Long id) throws NullFieldException, ElementNotFoundException {
        if( !favouriteDao.existsById(Optional.ofNullable(id).orElseThrow(() -> new NullFieldException("no post id as request param"))) ) 
            throw new ElementNotFoundException("Post not found");
        
        favouriteDao.deleteById(id);
    }

    @Override
    public List<FavouriteDto> getAll(Long userId) throws ElementNotFoundException {
        return favouriteDao.findAll().stream()
            .map(fav -> modelMapper.map(fav, FavouritePublishDto.class))
            .collect(Collectors.toList());
    }
}
