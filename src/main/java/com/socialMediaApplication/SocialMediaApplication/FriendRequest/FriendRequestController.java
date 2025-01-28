package com.socialMediaApplication.SocialMediaApplication.FriendRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friendRequests")
public class FriendRequestController {

    @Autowired
    private IServiceFriendRequest serviceFriendRequest;

    @PostMapping("/create")
    public ResponseEntity<FriendRequest> createFriendRequest(@RequestBody FriendRequest friendRequest){
        return new ResponseEntity<>(serviceFriendRequest.save(friendRequest), HttpStatus.CREATED);
    }

    @GetMapping("/receiver/{receiverId}")
    public ResponseEntity<List<FriendRequest>> getFriendRequestsByReceiverId(@PathVariable Long receiverId){
        return serviceFriendRequest.getByReceivedId(receiverId)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/sender/{senderId}")
    public ResponseEntity<List<FriendRequest>> getFriendRequestBySenderId(@PathVariable Long senderId){
        return serviceFriendRequest.getBySenderId(senderId)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

}
