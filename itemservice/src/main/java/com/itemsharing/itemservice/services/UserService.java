package com.itemsharing.itemservice.services;

import com.itemsharing.itemservice.model.User;

public interface UserService {
    User getUserByUsername(String username);
}
