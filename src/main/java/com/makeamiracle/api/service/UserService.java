package com.makeamiracle.api.service;

import com.makeamiracle.api.config.exception.NotFoundException;
import com.makeamiracle.api.domain.User;
import com.makeamiracle.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Long count(){
        return userRepository.count();
    }

    public User findById(Long id){
        if (!userRepository.existsById(id)) throw new NotFoundException("User does not exist with id " + id);
        return userRepository.getOne(id);
    }

    public User findByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    public Boolean login(User user){
        return userRepository.existsUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
