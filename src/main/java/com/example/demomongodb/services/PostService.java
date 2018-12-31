package com.example.demomongodb.services;

import com.example.demomongodb.domain.Post;
import com.example.demomongodb.exception.ObjectNotFoudException;
import com.example.demomongodb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by loliveira on 25/12/18.
 */
@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> byId = repository.findById(id);
        return byId.orElseThrow(() -> new ObjectNotFoudException("Value did not find"));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
