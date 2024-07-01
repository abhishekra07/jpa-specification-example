package com.codelabs.controller;

import com.codelabs.entity.User;
import com.codelabs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/by-username")
    public List<User> getUsersByUsername(@RequestParam String username) {
        return userService.getUsersWithUsername(username);
    }

    @GetMapping("/users/by-email")
    public List<User> getUsersByEmail(@RequestParam String email) {
        return userService.getUsersWithEmail(email);
    }

    @GetMapping("/users/by-post-content")
    public List<User> getUsersByPostContent(@RequestParam String content) {
        return userService.getUsersWithPostContent(content);
    }

    @GetMapping("/users/ordered-asc")
    public List<User> getUsersOrderedByUsernameAsc() {
        return userService.getUsersOrderedByUsernameAsc();
    }

    @GetMapping("/users/ordered-desc")
    public List<User> getUsersOrderedByUsernameDesc() {
        return userService.getUsersOrderedByUsernameDesc();
    }

    @GetMapping("/users/grouped-by-username")
    public List<User> getUsersGroupedByUsername() {
        return userService.getUsersGroupedByUsername();
    }
}