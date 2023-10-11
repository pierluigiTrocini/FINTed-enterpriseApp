package it.unical.demacs.pierluigi.fintedapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unical.demacs.pierluigi.fintedapp.data.services.UserService;
import it.unical.demacs.pierluigi.fintedapp.dto.UserDto;
import it.unical.demacs.pierluigi.fintedapp.dto.UserRegistrationDto;
import it.unical.demacs.pierluigi.fintedapp.exception.CredentialsAlreadyUsedException;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> save(@RequestBody UserRegistrationDto user) throws NullFieldException, CredentialsAlreadyUsedException{
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/")
    public void delete(@RequestParam Long id) throws ElementNotFoundException, NullFieldException{
        userService.delete(id);
    }

    @GetMapping("/{page}")
    public ResponseEntity<List<UserDto>> getAll(@PathVariable("page") Integer page){
        return ResponseEntity.ok(userService.getAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable("id") Long id) throws ElementNotFoundException, NullFieldException{
        return ResponseEntity.ok(userService.get(id));
    }

    @PutMapping("/")
    public ResponseEntity<UserDto> update(@RequestBody UserRegistrationDto user) throws ElementNotFoundException, NullFieldException{
        return ResponseEntity.ok(userService.update(user));
    }


}
