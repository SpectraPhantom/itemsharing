package com.itemsharing.itemservice.repositories;

import com.itemsharing.itemservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findUserByUsername(String username);
}
