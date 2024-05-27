package com.example.course.service.impl;

import com.example.course.entity.Account;
import com.example.course.model.request.GetAccountRequest;
import com.example.course.repository.AccountReposiroty;
import com.example.course.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService,UserDetailsService {

    @Autowired
    private AccountReposiroty accountReposiroty;
    @Override
    public List<Account> getAll() {
        return accountReposiroty.findAll();
    }

    @Override
    public Page<Account> getPageAccount(GetAccountRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        return accountReposiroty.getAccount(request,pageable);
    }

    @Override
    public Account addAccount(Account account) {
        Account account1 = new Account();
        account1.setId(generateAccoundId());
        account1.setFullName(account.getFullName());
        account1.setEmail(account.getEmail());
        account1.setPassword(account.getPassword());
        account1.setRole(account.getRole());
        account1.setGender(account.getGender());
        account1.setPhoneNumber(account.getPhoneNumber());
        account1.setDateOfBirth(account.getDateOfBirth());
        account1.setStatus(1);

        return accountReposiroty.save(account1);
    }

    @Override
    public Account updateAccount(Account account, String id) {
        Optional<Account> getOptional = accountReposiroty.findById(id);
        if(getOptional.isPresent()){
            Account accountUpdate = getOptional.get();
            accountUpdate.setFullName(account.getFullName());
            accountUpdate.setEmail(account.getEmail());
            accountUpdate.setPassword(account.getPassword());
            accountUpdate.setRole(account.getRole());
            accountUpdate.setGender(account.getGender());
            accountUpdate.setPhoneNumber(account.getPhoneNumber());
            accountUpdate.setDateOfBirth(account.getDateOfBirth());
            accountReposiroty.save(accountUpdate);
            return accountUpdate;
        }else {
            return null;
        }


    }

    @Override
    public Account getOne(String id) {
       return accountReposiroty.findById(id).orElse(null);
    }


    public String generateAccoundId(){
        String id = UUID.randomUUID().toString();
        return id;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountReposiroty.findByEmail(email);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(account.getEmail(), account.getPassword(), AuthorityUtils.createAuthorityList(account.getRole().toString()));
    }


}
