package com.example.course.controller;

import com.example.course.Security.AccountLogin;
import com.example.course.entity.Account;
import com.example.course.repository.AccountReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountReposiroty accountReposiroty;

    @GetMapping("/login")
    public Account greeting(@ModelAttribute AccountLogin accountLogin) {
        Account account = accountReposiroty.findByEmail(accountLogin.getUserName());
    return account;
    }
}
