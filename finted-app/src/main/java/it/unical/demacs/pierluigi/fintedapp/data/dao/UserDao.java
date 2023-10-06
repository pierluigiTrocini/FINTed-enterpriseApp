package it.unical.demacs.pierluigi.fintedapp.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import it.unical.demacs.pierluigi.fintedapp.data.entities.User;

public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{
    boolean existsByCredentialsEmail(String email);
}
