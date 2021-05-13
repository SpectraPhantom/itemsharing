package com.itemsharing.userservice.controllers;

import com.itemsharing.userservice.model.User;
import com.itemsharing.userservice.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
