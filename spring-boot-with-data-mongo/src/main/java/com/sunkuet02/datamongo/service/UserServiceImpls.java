package com.sunkuet02.datamongo.service;

import com.sunkuet02.datamongo.dao.AutoGenSequenceDao;
import com.sunkuet02.datamongo.dao.UserRepository;
import com.sunkuet02.datamongo.model.Users;
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

    private final static String AUTOGEN_SEQUENCE_NAME = "user_seq";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AutoGenSequenceDao sequenceDao;

    @Override
    public List<Users> getAllUser() {
        logger.info("*** " );
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public long insertUser(Users user) {
        if(user.getId() != null) return -1;
        user.setId(sequenceDao.getNextSequenceId(AUTOGEN_SEQUENCE_NAME));
        userRepository.save(user);

        return user.getId();
    }

    @Override
    public List<Users> getUserByUsername(String username) {
        return userRepository.getAllByUsername(username);
    }

    @Override
    public List<Users> getAllUserByRegex(String prefix) {
        logger.info("*** " + prefix);
        return userRepository.getAllByRegexQuery(prefix);
    }
}
