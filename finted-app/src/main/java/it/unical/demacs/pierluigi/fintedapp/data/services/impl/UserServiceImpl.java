package it.unical.demacs.pierluigi.fintedapp.data.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.unical.demacs.pierluigi.fintedapp.data.dao.UserDao;
import it.unical.demacs.pierluigi.fintedapp.data.entities.User;
import it.unical.demacs.pierluigi.fintedapp.data.services.UserService;
import it.unical.demacs.pierluigi.fintedapp.dto.UserPersonalProfileDto;
import it.unical.demacs.pierluigi.fintedapp.dto.UserProfileDto;
import it.unical.demacs.pierluigi.fintedapp.dto.UserRegistrationDto;
import it.unical.demacs.pierluigi.fintedapp.exception.CredentialsAlreadyUsedException;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private final ModelMapper modelMapper;

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public UserRegistrationDto save(UserRegistrationDto user) throws CredentialsAlreadyUsedException{
        if(userDao.existsByCredentialsEmail(user.getCredentialsEmail()))
            throw new CredentialsAlreadyUsedException("email already used");

        return modelMapper.map(userDao.save(
            modelMapper.map(user, User.class)
        ), UserRegistrationDto.class);
    }

    @Override
    public List<UserProfileDto> getAll(Integer page) {
        return userDao.findAll(PageRequest.of(page != null && page >= 0 ? page : 0, 10))
            .stream()
            .map(user -> modelMapper.map(user, UserProfileDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public UserProfileDto get(Long id) throws ElementNotFoundException, NullFieldException {
        return modelMapper.map(
            userDao.findById(Optional.ofNullable(id).orElseThrow(() -> new NullFieldException("no id as request param")))
                .orElseThrow(() -> new ElementNotFoundException("user not found")),
            UserProfileDto.class
        );
    }

    @Override
    public UserPersonalProfileDto getPersonalProfile(Long id) throws ElementNotFoundException, NullFieldException {
        return modelMapper.map(
            userDao.findById(Optional.ofNullable(id).orElseThrow(() -> new NullFieldException("no id as request param")))
                .orElseThrow(() -> new ElementNotFoundException("user not found")),
            UserPersonalProfileDto.class
        );
    }

    @Override
    public UserPersonalProfileDto update(UserPersonalProfileDto user) throws ElementNotFoundException, NullFieldException {
        User _user = userDao.findById(Optional.ofNullable(user.getId()).orElseThrow(() -> new NullFieldException("no id in request body"))).orElseThrow(() -> new ElementNotFoundException("user not found"));

        _user.getCredentials().setEmail(user.getCredentialsEmail());
        
        _user.getAddress().setCity(user.getAddress().getCity());
        _user.getAddress().setNumber(user.getAddress().getNumber());
        _user.getAddress().setRoute(user.getAddress().getRoute());        

        return modelMapper.map(userDao.save(_user), UserPersonalProfileDto.class);
    }

}
