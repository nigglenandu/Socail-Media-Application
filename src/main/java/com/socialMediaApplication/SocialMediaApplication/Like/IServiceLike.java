package com.socialMediaApplication.SocialMediaApplication.Like;

public interface IServiceLike {
    PostLike save(PostLike like);
    Long countByPostId(Long postId);
}
