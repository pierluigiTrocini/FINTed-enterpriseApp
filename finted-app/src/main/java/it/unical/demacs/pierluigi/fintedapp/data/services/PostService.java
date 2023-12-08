package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.PostDto;

public interface PostService {
    PostDto save(PostDto post);

    void delete(Long id);

    List<PostDto> getAll(Integer page);

    PostDto get(Long id);

    PostDto update(PostDto post);
}
