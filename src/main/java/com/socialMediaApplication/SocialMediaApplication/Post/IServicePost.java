package com.socialMediaApplication.SocialMediaApplication.Post;

import java.util.List;
import java.util.Optional;

public interface IServicePost {
    Post save(Post post);
    Optional<List<Post>> findByUserId(Long userId);
    Optional<Post> findById(Long id);
    void deleteById(Long id);
}
