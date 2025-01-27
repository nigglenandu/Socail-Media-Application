package com.socialMediaApplication.SocialMediaApplication.Like;

public interface IServiceLike {
    Like save(Like like);
    Long countByPostId(Long postId);
}
