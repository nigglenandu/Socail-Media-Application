package com.socialMediaApplication.SocialMediaApplication.Comment;


import java.util.List;
import java.util.Optional;

public interface IServiceComment {

    Comment save(Comment comment);
    Optional<List<Comment>> findByPostId(Long postId);
}
