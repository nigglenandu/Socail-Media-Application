package com.socialMediaApplication.SocialMediaApplication.UserProfile;

import java.util.Optional;

public interface IServiceUserProfile {
    UserProfile save(UserProfile userprofile);
    Optional<UserProfile> findByUserId(Long userId);
    void deleteById(Long id);
}
