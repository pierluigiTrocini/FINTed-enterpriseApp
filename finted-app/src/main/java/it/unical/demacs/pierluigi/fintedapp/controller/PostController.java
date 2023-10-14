package it.unical.demacs.pierluigi.fintedapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unical.demacs.pierluigi.fintedapp.data.services.PostService;
import it.unical.demacs.pierluigi.fintedapp.dto.PostDto;
import it.unical.demacs.pierluigi.fintedapp.dto.PostPublishDto;
import it.unical.demacs.pierluigi.fintedapp.exception.ElementNotFoundException;
import it.unical.demacs.pierluigi.fintedapp.exception.NullFieldException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/")
    public ResponseEntity<PostDto> save(@RequestBody PostPublishDto post) throws ElementNotFoundException{
        return ResponseEntity.ok(postService.save(post));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws NullFieldException, ElementNotFoundException{
        postService.delete(id);
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<List<PostDto>> getAll(@PathVariable("page") Integer page) throws ElementNotFoundException{
        return ResponseEntity.ok(postService.getAll(page));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PostDto> get(@PathVariable("id") Long id) throws ElementNotFoundException, NullFieldException{
        return ResponseEntity.ok(postService.get(id));
    }

    @PutMapping("/")
    public ResponseEntity<PostDto> update(@RequestBody PostPublishDto post) throws NullFieldException, ElementNotFoundException{
        return ResponseEntity.ok(postService.update(post));
    }

}
