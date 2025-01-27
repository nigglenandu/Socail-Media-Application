package com.socialMediaApplication.SocialMediaApplication.Like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeServiceImpl implements IServiceLike{
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public Like save(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public Optional<Long> countByPostId(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}
