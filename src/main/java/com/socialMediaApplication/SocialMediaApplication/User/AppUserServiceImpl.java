package com.socialMediaApplication.SocialMediaApplication.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements IServiceUser {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public AppUser save(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<AppUser> findByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username, email);
    }
}
