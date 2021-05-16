package com.itemsharing.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ItemserviceApplication {
    public static void main(String [] args){
        SpringApplication.run(ItemserviceApplication.class,args);
    }
}
