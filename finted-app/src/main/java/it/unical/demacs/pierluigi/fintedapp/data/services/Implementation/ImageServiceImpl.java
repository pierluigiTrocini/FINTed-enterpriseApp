package it.unical.demacs.pierluigi.fintedapp.data.services.Implementation;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.unical.demacs.pierluigi.fintedapp.data.dao.PostDao;
import it.unical.demacs.pierluigi.fintedapp.data.entities.Post;
import it.unical.demacs.pierluigi.fintedapp.data.services.ImageService;
import it.unical.demacs.pierluigi.fintedapp.dto.ImageDto;
import it.unical.demacs.pierluigi.fintedapp.dto.ImagePublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.InvalidArgumentException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final PostDao postDao;

    @Override
    public ImagePublishDto save(ImagePublishDto image)
            throws NullFieldException, ElementNotFoundException {
        Post post = postDao
                .findById(Optional.ofNullable(image.getPostId())
                        .orElseThrow(() -> new NullFieldException("no post id as request param")))
                .orElseThrow(() -> new ElementNotFoundException("post not found"));

        post.setPostImage(image.getData());

        ImagePublishDto imageResponse = null;

        if( postDao.save(post) != null )
                imageResponse = new ImagePublishDto(image.getPostId(), image.getData());
        

        return imageResponse;
    }

    @Override
    public void delete(Long postId) throws NullFieldException, ElementNotFoundException {
        Post post = postDao
                .findById(Optional.ofNullable(postId)
                        .orElseThrow(() -> new NullFieldException("no post id as request param")))
                .orElseThrow(() -> new ElementNotFoundException("post not found"));

        if (post.getPostImage() != null)
                post.setPostImage(null);
    }

    @Override
    public ImageDto getAll(Long postId) throws ElementNotFoundException, NullFieldException {
        Post post = postDao
                .findById(Optional.ofNullable(postId)
                        .orElseThrow(() -> new NullFieldException("no post id as request param")))
                .orElseThrow(() -> new ElementNotFoundException("post not found"));
        
        ImagePublishDto imageResponse = new ImagePublishDto();
        imageResponse.setPostId(post.getId());
        imageResponse.setData(post.getPostImage());

        return imageResponse;
    }

        @Override
        public ImagePublishDto saveParams(Long postId, MultipartFile file) throws InvalidArgumentException, ElementNotFoundException, NullFieldException, IOException {
                if(!file.getContentType().equals("image/jpg"))
                        throw new InvalidArgumentException("Invalid file type");
                
                Post p = postDao.findById(Optional.ofNullable(postId)
                        .orElseThrow(() -> new NullFieldException("no post id as request param")))
                        .orElseThrow(() -> new ElementNotFoundException("post not found"));
                
                p.setPostImage(file.getBytes().toString());

                postDao.save(p);

                return new ImagePublishDto(postId, file.getBytes().toString());
        }

}
