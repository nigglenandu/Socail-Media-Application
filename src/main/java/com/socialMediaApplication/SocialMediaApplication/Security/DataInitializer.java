package com.socialMediaApplication.SocialMediaApplication.Security;

import com.socialMediaApplication.SocialMediaApplication.User.AppUser;
import com.socialMediaApplication.SocialMediaApplication.User.AppUserRepository;
import org.hibernate.bytecode.internal.bytebuddy.PassThroughInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initData(UserDetailsService userDetailsService){
        return args -> {
            if(appUserRepository.findByUsernameOrEmail("user1", "user1@example.com").isEmpty()){
                AppUser user1 = new AppUser();
                user1.setUsername("user1");
                user1.setPassword(passwordEncoder.encode("password1"));
                user1.setEmail("user1@example.com");
                appUserRepository.save(user1);
            }

            if(appUserRepository.findByUsernameOrEmail("admin1", "admin1@example.com").isEmpty()){
                AppUser user1 = new AppUser();
                user1.setUsername("admin");
                user1.setPassword(passwordEncoder.encode("adminPass1"));
                user1.setEmail("admin1@example.com");
                appUserRepository.save(user1);
            }

        };
    }
}
