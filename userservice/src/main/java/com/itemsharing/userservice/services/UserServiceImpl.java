package com.itemsharing.userservice.services;

import com.itemsharing.userservice.model.Role;
import com.itemsharing.userservice.model.User;
import com.itemsharing.userservice.model.UserRole;
import com.itemsharing.userservice.repositories.UserRepository;
import com.itemsharing.userservice.utility.SecurityUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        User localUser=userRepository.findUserByUsername(user.getUsername());
        if(localUser!=null){
            log.info("User with username {} already exists.Nothing will be done.",user.getUsername());
        }else {
            Set<UserRole> userRoles = new HashSet<>();
            Role localRole = new Role();
            localRole.setId(1L);
            userRoles.add(new UserRole(user, localRole));
            user.getUserRoles().addAll(userRoles);

            LocalDate today = LocalDate.now();
            user.setJoinDate(today);

            String encryptedPassword = SecurityUtility.passwordEncoder().encode(user.getPassword());

            user.setPassword(encryptedPassword);

            localUser = userRepository.save(user);

        }
        return localUser;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
