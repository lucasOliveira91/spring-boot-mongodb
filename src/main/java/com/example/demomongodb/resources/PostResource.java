package com.example.demomongodb.resources;

import com.example.demomongodb.domain.Post;
import com.example.demomongodb.resources.util.URL;
import com.example.demomongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by loliveira on 25/12/18.
 */
@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService service;


    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = service.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ){
        text = URL.decodeParam(text);
        Date min = URL.converteDate(minDate, new Date(0L));
        Date max = URL.converteDate(maxDate, new Date());
        List<Post> posts = service.fullSearch(text,min, max);
        return ResponseEntity.ok().body(posts);
    }


}
