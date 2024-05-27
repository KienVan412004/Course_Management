package com.example.course.controller;

import com.example.course.entity.SendMail;
import com.example.course.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mail/")
@CrossOrigin("*")
public class SendMailController {

    @Autowired
    private SendMailService sendMailService;

    @PostMapping("add-mail")
    public SendMail addMail(@RequestBody SendMail sendMail){
        return sendMailService.addMail(sendMail);
    }

    @GetMapping("template-mail")
    public List<SendMail> listTemplateMail(){
        return sendMailService.getAllMail();
    }

    @GetMapping("get-one-send-mail/{id}")
    public SendMail getOneSendMail(@PathVariable String id){
        return sendMailService.getOneMail(id);
    }

    @PutMapping ("update-mail/{id}")
    public SendMail updateMail(@RequestBody SendMail sendMail, @PathVariable String id){
        return sendMailService.updateMail(sendMail,id);
    }
}
