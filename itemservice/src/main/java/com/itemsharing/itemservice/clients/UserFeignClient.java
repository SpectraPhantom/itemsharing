package com.itemsharing.itemservice.clients;

import com.itemsharing.itemservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserFeignClient {

    @GetMapping(value = "/v1/user/{username}",consumes = "application/json")
    User getUserByUsername(@PathVariable String username);
}
