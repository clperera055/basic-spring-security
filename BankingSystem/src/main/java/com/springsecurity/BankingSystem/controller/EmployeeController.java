package com.springsecurity.BankingSystem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")

public class EmployeeController {

    @GetMapping("/employee-details")
    @PreAuthorize("hasAnyRole ('ADMIN','EMPLOYEE')")
    public String payrollDetails(){

        return "Here's the employee details....";
    }


}
