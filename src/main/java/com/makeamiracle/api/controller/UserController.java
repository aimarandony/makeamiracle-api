package com.makeamiracle.api.controller;

import com.makeamiracle.api.domain.User;
import com.makeamiracle.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/login")
    public ResponseEntity<?> login(@RequestBody User user){
        Map<String, Object> resp = new HashMap<>();

        if (userService.login(user)) {
            resp.put("isValid", true);
            resp.put("msg", "Credenciales Válidas.");
            resp.put("user", userService.findByUsername(user.getUsername()));
        } else {
            resp.put("isValid", false);
            resp.put("msg", "Credenciales No Válidas.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }
}
