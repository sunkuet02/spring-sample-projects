package com.sunkuet02.datamongojpa.controller;

import com.sunkuet02.datamongojpa.model.Users;
import com.sunkuet02.datamongojpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sun on 8/16/17.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<Users> getUsers(@RequestParam(value = "username", required = false) String username) {
        if(username != null && !"".equals(username)) {
            return userService.getUserByUsername(username);
        }
        return userService.getAllUser();
    }

    @PostMapping("/users")
    public long insertUser(@RequestBody Users user) {
        return userService.insertUser(user);
    }

    @GetMapping("/users/{id}")
    public Users getUserById(@PathVariable(name = "id")Long id) {
        return userService.getUserById(id);
    }

}
