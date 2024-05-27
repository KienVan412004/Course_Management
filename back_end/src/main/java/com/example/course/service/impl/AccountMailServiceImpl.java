package com.example.course.service.impl;

import com.example.course.entity.AccountMail;
import com.example.course.repository.AccountMailRepository;
import com.example.course.service.AccountMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountMailServiceImpl implements AccountMailService {

    @Autowired
    private AccountMailRepository accountMailRepository;
    @Override
    public List<AccountMail> getAll() {
        return accountMailRepository.findAll();
    }



    @Override
    public AccountMail addAccountMail(AccountMail accountMail) {
        AccountMail accountMail1 = new AccountMail();
        accountMail1.setId(UUID.randomUUID().toString());
        accountMail1.setHost(accountMail.getHost());
        accountMail1.setPort(accountMail.getPort());
        accountMail1.setUsername(accountMail.getUsername());
        accountMail1.setPassword(accountMail.getPassword());
        accountMail1.setStatus(0);
        return accountMailRepository.save(accountMail1);
    }

    @Override
    public AccountMail updateStatusAccountMail( String id) {
        Optional<AccountMail> accountMail1 = accountMailRepository.findById(id);
        if(accountMail1.isPresent()){
            AccountMail accountMail2 = accountMail1.get();
            accountMail2.setStatus(1);

            List<AccountMail> accountMailList = accountMailRepository.findAll();
            for (AccountMail mail: accountMailList){
                if(!mail.getId().equals(id)){
                    mail.setStatus(0);
                }
            }
            accountMailRepository.saveAll(accountMailList);
            return accountMail2;
        }
        return null;
    }
}
