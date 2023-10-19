package it.unical.demacs.pierluigi.fintedapp.data.services.Implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.unical.demacs.pierluigi.fintedapp.data.dao.PostDao;
import it.unical.demacs.pierluigi.fintedapp.data.dao.UserDao;
import it.unical.demacs.pierluigi.fintedapp.data.entities.Post;
import it.unical.demacs.pierluigi.fintedapp.data.services.ImageService;
import it.unical.demacs.pierluigi.fintedapp.data.services.PostService;
import it.unical.demacs.pierluigi.fintedapp.dto.ImagePublishDto;
import it.unical.demacs.pierluigi.fintedapp.dto.PostDto;
import it.unical.demacs.pierluigi.fintedapp.dto.PostPublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.ImagesLimitExceededException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import it.unical.demacs.pierluigi.fintedapp.utility.DateManager;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDao postDao;
    private final UserDao userDao;

    private final ModelMapper modelMapper;

    private final ImageService imageService;
    
    @Override
    public PostDto save(PostPublishDto post) throws ElementNotFoundException, NullFieldException, ImagesLimitExceededException {
        Post newPost = new Post();

        newPost.setSeller( userDao.findById(post.getSeller().getId()).orElseThrow(() -> new ElementNotFoundException("User not found")) );
        newPost.setTitle( post.getTitle() );
        newPost.setStartingPrice( post.getStartingPrice() );
        newPost.setPublishDate( DateManager.getInstance().currentDate() );

        PostPublishDto output = modelMapper.map(postDao.save(newPost), PostPublishDto.class);
        
        if( output != null && post.getPostImage() != null ){
            output.setPostImage(
                imageService.save(new ImagePublishDto(output.getId(), post.getPostImage())).getData()
            );
        }

        return output;
    }

    @Override
    public void delete(Long id) throws NullFieldException, ElementNotFoundException {
        if(!postDao.existsById( Optional.ofNullable(id).orElseThrow(() -> new NullFieldException("no id as request param")) ))
            throw new ElementNotFoundException("Post not found");

        postDao.deleteById(id);
    }

    @Override
    public List<PostDto> getAll(Integer page) throws ElementNotFoundException {
        return postDao.findAll(PageRequest.of(page != null && page >= 0 ? page : 0, 10)).stream()
            .map(post -> modelMapper.map(post, PostPublishDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public PostDto get(Long id) throws ElementNotFoundException, NullFieldException {
        return modelMapper.map(
            postDao.findById(Optional.ofNullable(id).orElseThrow(() -> new NullFieldException("no id as request param")))
                .orElseThrow(() -> new ElementNotFoundException("Post not found")),
            PostPublishDto.class
        );
    }

    @Override
    public PostDto update(PostPublishDto post) throws NullFieldException, ElementNotFoundException {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}