package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "USER-CLIENT")
public interface UserClient {

    @GetMapping("/users")
    List<User> getUsers();
    // User -->> our own DTO Class


    //whenever you call this method, it will hit this end point "https://jsonplaceholder.typicode.com/users"
    //this end point will be executed with GetMapping and json is coming and json will be assigned to our own dto




}
