package it.unical.demacs.pierluigi.fintedapp.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unical.demacs.pierluigi.fintedapp.data.entities.Image;

public interface ImageDao extends JpaRepository<Image, Long>{
    List<Image> findAllByPostId(Long id);

    void deleteAllByPostId(Long id);

    void deleteByPostId(Long id);
}
