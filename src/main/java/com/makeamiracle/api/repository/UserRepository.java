package com.makeamiracle.api.repository;

import com.makeamiracle.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsUserByUsernameAndPassword(String username, String password);
    User findUserByUsername(String username);
}