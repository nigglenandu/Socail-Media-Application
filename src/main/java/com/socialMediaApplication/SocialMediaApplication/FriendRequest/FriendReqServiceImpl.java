package com.socialMediaApplication.SocialMediaApplication.FriendRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendReqServiceImpl implements IServiceFriendRequest{
    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Override
    public FriendRequest save(FriendRequest friendRequest) {
        return friendRequestRepository.save(friendRequest);
    }

    @Override
    public Optional<List<FriendRequest>> getByReceivedId(Long receiverId) {
        return friendRequestRepository.findByReceiverId(receiverId);
    }

    @Override
    public Optional<List<FriendRequest>> getBySenderId(Long senderId) {
        return friendRequestRepository.findBySenderId(senderId);
    }
}
