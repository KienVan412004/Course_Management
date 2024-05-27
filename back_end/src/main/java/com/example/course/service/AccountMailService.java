package com.example.course.service;

import com.example.course.entity.AccountMail;

import java.util.List;

public interface AccountMailService {

    List<AccountMail> getAll();

    AccountMail addAccountMail(AccountMail accountMail);

    AccountMail updateStatusAccountMail( String id);
}
