package com.socialMediaApplication.SocialMediaApplication.Like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public  class PostLikeServiceImpl implements IServiceLike{
    @Autowired
    private PostLikeRepository likeRepository;

    @Override
    public PostLike save(PostLike like) {
        return likeRepository.save(like);
    }

    @Override
    public Long countByPostId(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}
