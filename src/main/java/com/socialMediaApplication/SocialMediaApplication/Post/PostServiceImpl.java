package com.socialMediaApplication.SocialMediaApplication.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IServicePost{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<List<Post>> findByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
