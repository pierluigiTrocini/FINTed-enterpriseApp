package it.unical.demacs.pierluigi.fintedapp.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import it.unical.demacs.pierluigi.fintedapp.data.entities.Post;

public interface PostDao extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
    
}