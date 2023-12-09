package it.unical.demacs.pierluigi.fintedapp.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unical.demacs.pierluigi.fintedapp.data.entities.Favourite;
import it.unical.demacs.pierluigi.fintedapp.data.entities.User;


public interface FavouriteDao extends JpaRepository<Favourite, Long> {
    List<Favourite> findAllByUser(User user);

    List<Favourite> findAllByTarget(User target);
}
