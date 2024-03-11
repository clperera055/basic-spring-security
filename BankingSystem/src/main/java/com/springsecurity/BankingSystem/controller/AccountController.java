package com.springsecurity.BankingSystem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/account")

public class AccountController {

    @GetMapping("/account-details")
    public String accountDetails(){
        return "Here's the account details....";
    }
}
