package com.itemsharing.userservice.repositories;

import com.itemsharing.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findUserByUsername(String username);
}
