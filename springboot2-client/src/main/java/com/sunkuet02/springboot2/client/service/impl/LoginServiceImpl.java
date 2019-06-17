package com.sunkuet02.springboot2.client.service.impl;

import com.sunkuet02.springboot2.client.entity.LoginRequest;
import com.sunkuet02.springboot2.client.entity.LoginResponse;
import com.sunkuet02.springboot2.client.service.LoginService;
import com.sunkuet02.springboot2.client.utils.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl extends ServiceUtil implements LoginService {


    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public LoginResponse login(LoginRequest request) throws Exception {
        LoginResponse response = sendHttpRequest(HttpMethod.POST, AUTH_SERVER_URI, request, httpServletRequest, LoginResponse.class) ;

        if(response.getAccess_token() == null || response.getAccess_token().isEmpty()) {
            throw new Exception("Invalid username or password.");
        }
        return response;
    }
}
