package it.unical.demacs.pierluigi.fintedapp.data.services.Implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.unical.demacs.pierluigi.fintedapp.data.dao.UserDao;
import it.unical.demacs.pierluigi.fintedapp.data.entities.Address;
import it.unical.demacs.pierluigi.fintedapp.data.entities.Credentials;
import it.unical.demacs.pierluigi.fintedapp.data.entities.User;
import it.unical.demacs.pierluigi.fintedapp.data.services.UserService;
import it.unical.demacs.pierluigi.fintedapp.dto.UserBasicInfoDto;
import it.unical.demacs.pierluigi.fintedapp.dto.UserDto;
import it.unical.demacs.pierluigi.fintedapp.dto.UserProfileDto;
import it.unical.demacs.pierluigi.fintedapp.dto.UserRegistrationDto;
import it.unical.demacs.pierluigi.fintedapp.exception.CredentialsAlreadyUsedException;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import it.unical.demacs.pierluigi.fintedapp.utility.DateManager;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final ModelMapper modelMapper;

    @Override
    public UserDto save(UserRegistrationDto user) throws NullFieldException, CredentialsAlreadyUsedException {
        if(userDao.existsByCredentialsEmail(user.getCredentials().getEmail()))
            throw new CredentialsAlreadyUsedException("email already used");

        User newUser = new User();
        
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setCredentials(
            new Credentials(
                user.getCredentials().getEmail(),
                user.getCredentials().getUsername(),
                user.getCredentials().getPassword() //TODO ENCRYPT PASSWORD
            )
        );
        newUser.setAddress(modelMapper.map(user.getAddress(), Address.class));
        newUser.setBalance((long) 500);
        newUser.setRegistrationDate(DateManager.getInstance().currentDate());

        return modelMapper.map(
            userDao.save(newUser),
            UserRegistrationDto.class
        );
    }


    @Override
    public void delete(Long id) throws ElementNotFoundException, NullFieldException {
        if( !userDao.existsById( Optional.ofNullable(id).orElseThrow(() -> new NullFieldException("no id as requet param"))))
            throw new ElementNotFoundException("User not found");
        
        userDao.deleteById(id);
    }

    @Override
    public List<UserDto> getAll(Integer page) {
        return userDao.findAll(PageRequest.of(page != null && page >= 0 ? page : 0, 10))
            .stream()
            .map(user -> modelMapper.map(user, UserBasicInfoDto.class))
            .collect(Collectors.toList());
            
    }

    @Override
    public UserDto get(Long id) throws ElementNotFoundException, NullFieldException {
        return modelMapper.map(
            userDao.findById(Optional.ofNullable(id).orElseThrow(() -> new NullFieldException("no id as request param")))
                .orElseThrow(() -> new ElementNotFoundException("user not found")),
            UserProfileDto.class
        );
    }

    @Override
    public UserDto update(UserRegistrationDto user) throws ElementNotFoundException, NullFieldException {
        User _user = userDao.findById(Optional.ofNullable(user.getId()).orElseThrow(() -> new NullFieldException("no id in request body"))).orElseThrow(() -> new ElementNotFoundException("user not found"));

        _user.setFirstName(user.getFirstName());
        _user.setLastName(user.getLastName());

        _user.setCredentials(
            new Credentials(
                user.getCredentials().getEmail(),
                user.getCredentials().getUsername(),
                user.getCredentials().getPassword()
            )
        );

        return modelMapper.map(userDao.save(_user), UserRegistrationDto.class);
    }
    
}
