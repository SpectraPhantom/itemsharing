package com.itemsharing.userservice.services;

import com.itemsharing.userservice.model.User;

public interface UserService {
    User createUser(User user);

    User getUserByUsername(String username);
}
