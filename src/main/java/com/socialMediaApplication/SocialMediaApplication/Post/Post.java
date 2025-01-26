package com.socialMediaApplication.SocialMediaApplication.Post;

import com.socialMediaApplication.SocialMediaApplication.User.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Content is mandatory")
    private String content;

    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name  = "user_id")
    private User user;

    public @NotNull(message = "Content is mandatory") String getContent() {
        return content;
    }

    public void setContent(@NotNull(message = "Content is mandatory") String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
