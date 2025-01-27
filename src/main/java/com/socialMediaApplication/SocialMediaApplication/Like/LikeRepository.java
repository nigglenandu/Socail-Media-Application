package com.socialMediaApplication.SocialMediaApplication.Like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Long> countByPostId(Long postId);
}
