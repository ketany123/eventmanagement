package com.eventmanagement.demo.controller;

import com.eventmanagement.demo.entity.Users;
import com.eventmanagement.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UserController {
    @Autowired
   private UserService userService;

    @PostMapping("/signup")
    public Users signup(@RequestBody Users user){
        Users users = userService.register(user);
        return users;
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        String token = userService.verify(user);
        return token;
    }

    @GetMapping("/auth")
    public String auth()
    {
        return "success";
    }


}
