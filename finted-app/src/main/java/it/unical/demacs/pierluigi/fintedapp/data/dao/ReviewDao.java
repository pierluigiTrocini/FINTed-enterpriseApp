package it.unical.demacs.pierluigi.fintedapp.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unical.demacs.pierluigi.fintedapp.data.entities.Review;
import it.unical.demacs.pierluigi.fintedapp.data.entities.User;

public interface ReviewDao extends JpaRepository<Review, Long>{
    List<Review> findAllByUser(User user);
    List<Review> findAllByAuthor(User author);
}
