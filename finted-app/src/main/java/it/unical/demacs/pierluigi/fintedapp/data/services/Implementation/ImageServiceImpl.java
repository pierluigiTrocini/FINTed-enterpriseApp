package it.unical.demacs.pierluigi.fintedapp.data.services.Implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import it.unical.demacs.pierluigi.fintedapp.data.dao.ImageDao;
import it.unical.demacs.pierluigi.fintedapp.data.dao.PostDao;
import it.unical.demacs.pierluigi.fintedapp.data.entities.Image;
import it.unical.demacs.pierluigi.fintedapp.data.services.ImageService;
import it.unical.demacs.pierluigi.fintedapp.dto.ImageDto;
import it.unical.demacs.pierluigi.fintedapp.dto.ImagePublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.ImagesLimitExceededException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageDao imageDao;
    private final PostDao postDao;

    private final ModelMapper modelMapper;
    
    @Override
    public ImageDto save(ImagePublishDto image)
            throws NullFieldException, ElementNotFoundException, ImagesLimitExceededException {
        Image newImage = new Image();

        newImage.setPost( postDao.findById( image.getPost().getId() ).orElseThrow(() -> new ElementNotFoundException("Post not found")) );
        newImage.setData( image.getData() );
            
        return modelMapper.map( imageDao.save(newImage) , ImagePublishDto.class);
    }

    @Override
    public void delete(Long postId, Long imageId) throws NullFieldException, ElementNotFoundException {
        if( !postDao.existsById(Optional.ofNullable(postId).orElseThrow(() -> new NullFieldException("no post id as request param"))) ) 
            throw new ElementNotFoundException("Post not found");
        if( !imageDao.existsById(Optional.ofNullable(imageId).orElseThrow(() -> new NullFieldException("no image id as request param"))))
            throw new ElementNotFoundException("Image not found");

        imageDao.deleteById(imageId);
    }

    @Override
    public ImageDto getAll(Long postId) throws ElementNotFoundException {
        return modelMapper.map(imageDao.findByPostId(postId), ImagePublishDto.class);
    }
    
}
