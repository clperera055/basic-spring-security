package com.springsecurity.BankingSystem.controller;

import com.springsecurity.BankingSystem.model.User;
import com.springsecurity.BankingSystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/sign-up")

public class SignUpController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> addUser(@RequestBody User user) {

        ResponseEntity response = null;

        try {

            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            user.setRole("ROLE_" + user.getRole());
            User saveUser = userRepo.save(user);

            if (saveUser.getId() > 0) {
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body(user.getEmail() +" save successfully....");
            }
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error : " + e.getMessage());
        }
        return response;
    }

}
