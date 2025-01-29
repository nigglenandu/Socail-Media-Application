package com.socialMediaApplication.SocialMediaApplication.Security;

import com.socialMediaApplication.SocialMediaApplication.User.AppUser;
import com.socialMediaApplication.SocialMediaApplication.User.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = appUserRepository.findByUsernameOrEmail(username, username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("user not found with username:" + username);
        }
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
    }
}
