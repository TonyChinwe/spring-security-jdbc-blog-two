package com.phisoft.springsecurityjdbcblogtwo.controller;

import com.phisoft.springsecurityjdbcblogtwo.entities.User;
import com.phisoft.springsecurityjdbcblogtwo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    private final UserService userService;
    public HomeController(UserService userService){
     this.userService=userService;
    }

    @GetMapping("/hello")
    public String hello(){
      return "Hello World";

    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
    if (userService.registerUser(user)){
        return "User saved Successfully";
    }else {
        return "Error occurred";
    }

    }
}
