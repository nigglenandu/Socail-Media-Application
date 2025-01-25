package com.socialMediaApplication.SocialMediaApplication.UserProfile;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/userProfiles")
public class UserProfileController {
    @Autowired
    private IServiceUserProfile serviceUserProfile;

    @PostMapping("/create")
    public ResponseEntity<UserProfile> createUserProfile(@Valid @RequestBody UserProfile userProfile){
        return new ResponseEntity<>(serviceUserProfile.save(userProfile), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable Long userId){
        return serviceUserProfile.findByUserId(userId)
                .map(profile  -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update")
    public ResponseEntity<UserProfile> updateUserProfile(@Valid @RequestBody UserProfile userProfile){
        return new ResponseEntity<>(serviceUserProfile.save(userProfile), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id){
        serviceUserProfile.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
