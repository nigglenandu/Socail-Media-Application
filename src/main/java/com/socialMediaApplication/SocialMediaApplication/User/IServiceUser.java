package com.socialMediaApplication.SocialMediaApplication.User;

import java.util.Optional;

public interface IServiceUser {
    AppUser save(AppUser user);
    Optional<AppUser> findByUsernameOrEmail(String username, String email);
}
