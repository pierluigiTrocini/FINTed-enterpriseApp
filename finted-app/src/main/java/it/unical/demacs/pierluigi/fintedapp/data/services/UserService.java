package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.UserPersonalProfileDto;
import it.unical.demacs.pierluigi.fintedapp.dto.UserProfileDto;
import it.unical.demacs.pierluigi.fintedapp.dto.UserRegistrationDto;
import it.unical.demacs.pierluigi.fintedapp.exception.CredentialsAlreadyUsedException;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;

public interface UserService {
    void delete(Long id);

    UserRegistrationDto save(UserRegistrationDto user) throws CredentialsAlreadyUsedException;

    List<UserProfileDto> getAll(Integer page);

    UserProfileDto get(Long id) throws ElementNotFoundException, NullFieldException;

    UserPersonalProfileDto getPersonalProfile(Long id) throws ElementNotFoundException, NullFieldException;

    UserPersonalProfileDto update(UserPersonalProfileDto user) throws ElementNotFoundException, NullFieldException;

}
