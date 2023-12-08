package it.unical.demacs.pierluigi.fintedapp.data.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.unical.demacs.pierluigi.fintedapp.data.dao.PostDao;
import it.unical.demacs.pierluigi.fintedapp.data.entities.Post;
import it.unical.demacs.pierluigi.fintedapp.data.services.PostService;
import it.unical.demacs.pierluigi.fintedapp.dto.PostDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostDao postDao;

    private final ModelMapper modelMapper;

    @Override
    public PostDto save(PostDto post) {
        return modelMapper.map(postDao.save(modelMapper.map(post, Post.class)), PostDto.class);
    }

    @Override
    public void delete(Long id) {
        postDao.deleteById(id);
    }

    @Override
    public List<PostDto> getAll(Integer page) {
        return postDao.findAll(PageRequest.of(page != null && page >= 0 ? page : 0, 10))
            .stream()
            .map(user -> modelMapper.map(user, PostDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public PostDto get(Long id) throws ElementNotFoundException, NullFieldException {
        return modelMapper.map(
            postDao.findById(Optional.ofNullable(id).orElseThrow(() -> new NullFieldException("no id as request param")))
                .orElseThrow(() -> new ElementNotFoundException("user not found")),
            PostDto.class
        );
    }

    @Override
    public PostDto update(PostDto post) throws ElementNotFoundException, NullFieldException {
        Post _post = postDao.findById(Optional.ofNullable(post.getId()).orElseThrow(() -> new NullFieldException("no id value")))
            .orElseThrow(() -> new ElementNotFoundException("post not found"));

        _post.setTitle(post.getTitle());
        _post.setStartingPrice(post.getStartingPrice());

        return modelMapper.map(postDao.save(_post), PostDto.class);
    }

}
