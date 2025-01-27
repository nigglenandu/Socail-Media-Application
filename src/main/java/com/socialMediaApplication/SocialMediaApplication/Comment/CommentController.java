package com.socialMediaApplication.SocialMediaApplication.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentController {
    @Autowired
    private IServiceComment serviceComment;

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
        return new ResponseEntity<>(serviceComment.save(comment), HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getByPostId(@PathVariable Long postId){
        return serviceComment.findByPostId(postId)
                .map(comments ->  new ResponseEntity<>(comments, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

}
