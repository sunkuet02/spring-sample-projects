package com.sunkuet02.datamongojpa.service;

import com.sunkuet02.datamongojpa.dao.AutoGenSequenceDao;
import com.sunkuet02.datamongojpa.dao.UserRepository;
import com.sunkuet02.datamongojpa.dao.ProductRepository;
import com.sunkuet02.datamongojpa.model.Users;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sun on 8/17/17.
 */

@Service
public class UserServiceImpls implements UserService {
    private final static Logger logger = Logger.getLogger(UserServiceImpls.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public long insertUser(Users user) {
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public List<Users> getUserByUsername(String username) {
        return userRepository.getAllByUsername(username);
    }

}
