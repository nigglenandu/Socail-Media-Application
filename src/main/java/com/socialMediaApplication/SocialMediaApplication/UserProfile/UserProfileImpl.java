package com.socialMediaApplication.SocialMediaApplication.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileImpl implements IServiceUserProfile{

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile save(UserProfile userprofile) {
        return userProfileRepository.save(userprofile);
    }

    @Override
    public Optional<UserProfile> findById(Long userId) {
        return userProfileRepository.findByUserId(userId);
    }

    @Override
    public void deleteById(Long id) {
        userProfileRepository.deleteById(id);
    }
}
