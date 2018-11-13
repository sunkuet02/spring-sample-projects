package com.sunkuet02.springbootvalidation.controller;

import com.sunkuet02.springbootvalidation.dto.Account;
import com.sunkuet02.springbootvalidation.dto.User;
import com.sunkuet02.springbootvalidation.services.GreetingService;
import com.sunkuet02.springbootvalidation.validations.ValidAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greetings")
    public ResponseEntity<String> getAll() {
        Integer c = 4/0;
        return new ResponseEntity<String>("Greetings", HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> postUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/balance")
    public ResponseEntity<Account> postBalance(@Valid @RequestBody Account account){
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
