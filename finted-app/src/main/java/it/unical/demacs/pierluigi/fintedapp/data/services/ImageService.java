package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.util.List;

import it.unical.demacs.pierluigi.fintedapp.dto.ImageDto;
import it.unical.demacs.pierluigi.fintedapp.dto.ImagePublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.ImagesLimitExceededException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;

public interface ImageService {
    ImageDto save(ImagePublishDto image) throws NullFieldException, ElementNotFoundException, ImagesLimitExceededException;

    void delete(Long postId, Long imageId) throws NullFieldException, ElementNotFoundException;

    List<ImageDto> getAll(Long postId) throws ElementNotFoundException;
}
