package com.springsecurity.BankingSystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/payroll")

public class PayrollController {

    @GetMapping("/payroll-details")
    public String payrollDetails(){
        return "Here's the payroll details....";
    }
}
