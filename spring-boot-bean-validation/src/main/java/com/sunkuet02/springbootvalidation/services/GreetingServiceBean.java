package com.sunkuet02.springbootvalidation.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceBean implements GreetingService {
    @Override
    public String hello() {
        return "hello";
    }
}
