package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.PostDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;

public interface PostService {
    PostDto save(PostDto post);

    void delete(Long id);

    List<PostDto> getAll(Integer page);

    PostDto get(Long id) throws ElementNotFoundException, NullFieldException;

    PostDto update(PostDto post) throws ElementNotFoundException, NullFieldException;
}
