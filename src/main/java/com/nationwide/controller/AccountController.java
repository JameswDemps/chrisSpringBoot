package com.nationwide.controller;

import com.nationwide.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/token")
    public String tokenCreator(){
        return accountService.tokenCreator();
    }
}
