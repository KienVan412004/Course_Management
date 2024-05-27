package com.example.course.common;

import com.example.course.entity.AccountMail;
import com.example.course.repository.AccountMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Properties;

@EnableScheduling
@Configuration
public class ConfigMail {


    @Autowired
    private AccountMailRepository accountMailRepository;

    private JavaMailSenderImpl mailSender;

    @Bean
    public JavaMailSender javaMailSender() {
        AccountMail accountMail = accountMailRepository.findByActiveTrue();
        mailSender = new JavaMailSenderImpl();
        mailSender.setHost(accountMail.getHost());
        mailSender.setPort(accountMail.getPort());
        mailSender.setUsername(accountMail.getUsername());
        mailSender.setPassword(accountMail.getPassword());
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable", "true");
        return mailSender;
    }

    @Scheduled(fixedDelay = 60000)
    public void refreshJavaMailSender() {
        AccountMail accountMail = accountMailRepository.findByActiveTrue();
        mailSender.setHost(accountMail.getHost());
        mailSender.setPort(accountMail.getPort());
        mailSender.setUsername(accountMail.getUsername());
        mailSender.setPassword(accountMail.getPassword());
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable", "true");
    }


}
