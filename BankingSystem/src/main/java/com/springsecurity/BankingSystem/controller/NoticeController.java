package com.springsecurity.BankingSystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/notices")

public class NoticeController {

    @GetMapping("/notice-details")
    public String noticeDetails(){
        return "Here's the notice details....";
    }
}
