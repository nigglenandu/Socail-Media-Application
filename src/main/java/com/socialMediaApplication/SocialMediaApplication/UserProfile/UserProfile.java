package com.socialMediaApplication.SocialMediaApplication.UserProfile;

import com.socialMediaApplication.SocialMediaApplication.User.AppUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name is mandatory")
    private String firstName;

    @NotNull(message = "Last name is mandatory")
    private String lastName;

    private String bio;
    private String profilePicture;

    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
}
