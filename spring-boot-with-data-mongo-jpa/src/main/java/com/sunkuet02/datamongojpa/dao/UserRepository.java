package com.sunkuet02.datamongojpa.dao;

import com.sunkuet02.datamongojpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> getAllByUsername(String username);
}
