package it.unical.demacs.pierluigi.fintedapp.data.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import it.unical.demacs.pierluigi.fintedapp.dto.ImageDto;
import it.unical.demacs.pierluigi.fintedapp.dto.ImagePublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.InvalidArgumentException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;

public interface ImageService {
    ImagePublishDto save(ImagePublishDto image) throws NullFieldException, ElementNotFoundException;

    ImagePublishDto saveParams(Long postId, MultipartFile file) throws InvalidArgumentException, ElementNotFoundException, NullFieldException, IOException;

    void delete(Long postId) throws NullFieldException, ElementNotFoundException;

    ImageDto getAll(Long postId) throws ElementNotFoundException, NullFieldException;
}
