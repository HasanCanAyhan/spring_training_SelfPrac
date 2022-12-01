package com.cydeo.controller;

import com.cydeo.client.EmployeeClient;
import com.cydeo.client.UserClient;
import com.cydeo.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {

    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    // our own api "/api/v1/users" , when it will be called, then userClient.getUsers method will be called
    //Then whenever you call this method "getUsers()" in the UserClient Interface , it will hit this end point "https://jsonplaceholder.typicode.com/users"
    //this end point will be executed with GetMapping and json is coming and json will be assigned to our own dto
    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers(){
        return ResponseEntity.ok(new ResponseWrapper("UserList Retrieved", userClient.getUsers()));
    }

    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper> getEmployee(){

        return ResponseEntity.ok(new ResponseWrapper("Employee Retrieved",employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }


}
