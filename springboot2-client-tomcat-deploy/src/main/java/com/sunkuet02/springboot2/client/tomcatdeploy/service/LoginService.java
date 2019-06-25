package com.sunkuet02.springboot2.client.tomcatdeploy.service;

import com.sunkuet02.springboot2.client.tomcatdeploy.entity.LoginRequest;
import com.sunkuet02.springboot2.client.tomcatdeploy.entity.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest request) throws Exception;
}
