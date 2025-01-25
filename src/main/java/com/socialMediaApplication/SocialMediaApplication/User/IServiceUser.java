package com.socialMediaApplication.SocialMediaApplication.User;

import java.util.Optional;

public interface IServiceUser {
    User save(User user);
    Optional<User> findByUsernameOrEmail(String username, String email);
}
