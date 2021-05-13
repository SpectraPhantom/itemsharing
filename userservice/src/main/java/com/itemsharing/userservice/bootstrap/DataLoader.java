package com.itemsharing.userservice.bootstrap;

import com.itemsharing.userservice.model.Role;
import com.itemsharing.userservice.model.User;
import com.itemsharing.userservice.model.UserRole;
import com.itemsharing.userservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    
    private final UserService userService;

    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUsers();
    }

    public void loadUsers(){
        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Adams");
        user1.setUsername("jadams");
        user1.setPassword("password");
        user1.setEmail("jadams@gmail.com");

        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1);
    }
}
