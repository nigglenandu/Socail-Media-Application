package com.socialMediaApplication.SocialMediaApplication.FriendRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest,Long> {
    Optional<List<FriendRequest>> findByReceiverId(Long receiverId);

    Optional<List<FriendRequest>> findBySenderId(Long senderId);
}
