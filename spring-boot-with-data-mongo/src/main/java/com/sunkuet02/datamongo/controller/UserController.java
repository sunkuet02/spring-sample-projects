package com.sunkuet02.datamongo.controller;

import com.sunkuet02.datamongo.model.Users;
import com.sunkuet02.datamongo.service.UserService;
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
    public List<Users> getUsers(@RequestParam(value = "username", required = false) String username,
                                @RequestParam(value = "regex", required = false) String regex) {
        if(username != null && !"".equals(username)) {
            return userService.getUserByUsername(username);
        } else if(regex != null && !"".equals(regex)) {
            return userService.getAllUserByRegex(regex);
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
