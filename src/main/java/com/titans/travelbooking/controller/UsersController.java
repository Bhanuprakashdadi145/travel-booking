package com.titans.travelbooking.controller;

import com.titans.travelbooking.dto.UserRequest;
import com.titans.travelbooking.entity.Users;
import com.titans.travelbooking.service.userservice.IUserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
     private IUserService userService;
    @PostMapping("/register")
    public ResponseEntity<Users> saveUser(@RequestBody @Valid UserRequest userRequest){
        System.out.println(userRequest);
        Users user=userService.saveUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/greet")
    public String greetMessage(){
        return "hello user controller setup is ready";
    }

}
