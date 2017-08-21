package com.sunkuet02.datamongo.dao;

import com.sunkuet02.datamongo.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by sun on 8/17/17.
 */
public interface UserRepository extends MongoRepository<Users, Long> {
    List<Users> getAllByUsername(String username);

    @Query("{username : {$regex: ?0}}")
    List<Users> getAllByRegexQuery(String regex);
}
