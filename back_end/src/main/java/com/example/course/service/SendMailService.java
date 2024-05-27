package com.example.course.service;

import com.example.course.entity.SendMail;

import java.util.List;

public interface SendMailService {

    SendMail addMail(SendMail sendMail);

    List<SendMail> getAllMail();

    SendMail getOneMail(String id);

    SendMail updateMail(SendMail sendMail , String id);
}
