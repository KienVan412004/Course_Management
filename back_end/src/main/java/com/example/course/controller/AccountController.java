package com.example.course.controller;

import com.example.course.entity.Account;
import com.example.course.model.request.GetAccountRequest;
import com.example.course.model.response.GetAccountResponse;
import com.example.course.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/account/")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("getAll")
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("get-page")
    public Page<Account> getPage(GetAccountRequest request){
        return accountService.getPageAccount(request);
    }

    @PostMapping("/add-account")
    public Account addAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }

    @PutMapping("/update-account/{id}")
    public Account updateAccount(@RequestBody Account account, @PathVariable String id){
        return accountService.updateAccount(account,id);
    }

    @GetMapping("/get-one/{id}")
    public Account getOneAccount(@PathVariable String id){
        return accountService.getOne(id);
    }

}
