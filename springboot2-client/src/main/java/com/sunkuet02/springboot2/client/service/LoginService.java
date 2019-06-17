package com.sunkuet02.springboot2.client.service;

import com.sunkuet02.springboot2.client.entity.LoginRequest;
import com.sunkuet02.springboot2.client.entity.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest request) throws Exception;
}
