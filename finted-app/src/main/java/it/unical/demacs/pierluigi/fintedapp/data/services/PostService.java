package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.PostDto;
import it.unical.demacs.pierluigi.fintedapp.dto.PostPublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;

public interface PostService {
    PostDto save(PostPublishDto post) throws ElementNotFoundException;

    void delete(Long id) throws NullFieldException, ElementNotFoundException;

    List<PostDto> getAll(Long page) throws ElementNotFoundException;

    PostDto get(Long id) throws ElementNotFoundException, NullFieldException;

    PostDto update(PostPublishDto post) throws NullFieldException, ElementNotFoundException;
}
