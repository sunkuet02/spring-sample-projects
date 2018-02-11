package com.sunkuet02.datamongojpa.service;

import com.sunkuet02.datamongojpa.model.Users;

import java.util.List;

/**
 * Created by sun on 8/16/17.
 */
public interface UserService {
    List<Users> getAllUser();

    Users getUserById(Long id);

    long insertUser(Users user);

    List<Users> getUserByUsername(String username);

}
