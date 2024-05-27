package com.example.course.controller;

import com.example.course.entity.AccountMail;
import com.example.course.service.AccountMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-mail/")
@CrossOrigin("*")
public class AccountMailController {

    @Autowired
    private AccountMailService accountMailService;

    @GetMapping("get-all")
    public List<AccountMail> getAll(){
        return accountMailService.getAll();
    }

    @PostMapping("add-account-mail")
    public AccountMail addAccountMail(@RequestBody AccountMail accountMail){
        return accountMailService.addAccountMail(accountMail);
    }

    @PutMapping("update-status/{id}")
    public AccountMail updateAccountMail(@PathVariable String id){
        return accountMailService.updateStatusAccountMail(id);
    }
}
