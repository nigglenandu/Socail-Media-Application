package com.socialMediaApplication.SocialMediaApplication.Like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class PostLikeController {

    @Autowired
    private IServiceLike serviceLike;

    @PostMapping("/create")
    public ResponseEntity<PostLike> createLike(@RequestBody PostLike like){
        return new ResponseEntity<>(serviceLike.save(like), HttpStatus.CREATED);
    }

    @GetMapping("/count/{postId}")
    public ResponseEntity<Long> countLikes(@PathVariable Long postId){
       Long likeCount = serviceLike.countByPostId(postId);
       return new ResponseEntity<>(likeCount, likeCount > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}
