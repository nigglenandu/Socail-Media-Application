package com.socialMediaApplication.SocialMediaApplication.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements IServiceComment{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Optional<List<Comment>> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
