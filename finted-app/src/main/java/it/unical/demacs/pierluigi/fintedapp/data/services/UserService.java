package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.UserDto;
import it.unical.demacs.pierluigi.fintedapp.dto.UserRegistrationDto;
import it.unical.demacs.pierluigi.fintedapp.exception.CredentialsAlreadyUsedException;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;

public interface UserService {
    UserDto save(UserRegistrationDto user) throws NullFieldException, CredentialsAlreadyUsedException;

    void delete(Long id) throws ElementNotFoundException, NullFieldException;

    List<UserDto> getAll(Long page);

    UserDto get(Long id) throws ElementNotFoundException, NullFieldException;

    UserDto update(UserRegistrationDto user) throws ElementNotFoundException, NullFieldException;
    
}
