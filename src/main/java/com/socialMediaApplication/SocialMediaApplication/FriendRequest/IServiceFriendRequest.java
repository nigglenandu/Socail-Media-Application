package com.socialMediaApplication.SocialMediaApplication.FriendRequest;

import java.util.List;
import java.util.Optional;

public interface IServiceFriendRequest {
    FriendRequest save(FriendRequest friendRequest);
    Optional<List<FriendRequest>> getByReceivedId(Long receiverId);
    Optional<List<FriendRequest>> getBySenderId(Long senderId);
}
