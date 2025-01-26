package com.socialMediaApplication.SocialMediaApplication.Post;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private IServicePost servicePost;

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post){
        return new ResponseEntity<>(servicePost.save(post), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostByUserId(@PathVariable Long userId){
        return servicePost.findByUserId(userId)
                .map(post -> new ResponseEntity<>(post, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        return servicePost.findById(id)
                .map(post -> new ResponseEntity<>(post, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PutMapping("/update")
    public ResponseEntity<Post> updatePost(@Valid @RequestBody Post post){
        return new ResponseEntity<>(servicePost.save(post), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id){
        servicePost.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
