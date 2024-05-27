package com.example.course.controller;

import com.example.course.entity.SendMail;
import com.example.course.model.request.MailStructure;
import com.example.course.service.impl.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mail/")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("send-mail/{mail}")
    public String sendMail(@PathVariable String mail, @RequestBody MailStructure mailStructure){
         mailService.sendMail(mail,mailStructure);
         return "send mail succesfully";
    }


}
