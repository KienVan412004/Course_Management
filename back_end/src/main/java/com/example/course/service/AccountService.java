package com.example.course.service;

import com.example.course.entity.Account;
import com.example.course.model.request.GetAccountRequest;
import com.example.course.model.response.GetAccountResponse;
import org.hibernate.sql.Update;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> getAll();

    Page<Account> getPageAccount(GetAccountRequest request);

    Account addAccount(Account account);

    Account updateAccount(Account account, String id);

    Account getOne(String id);



}
