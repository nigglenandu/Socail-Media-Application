package com.socialMediaApplication.SocialMediaApplication.User;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IServiceUser userService;

    @PostMapping("/register")
    private ResponseEntity<User> registerUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<User> getUserByUsernameOrEmail(@RequestParam String user, String email){
        return userService.findByUsernameOrEmail(user, email)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
