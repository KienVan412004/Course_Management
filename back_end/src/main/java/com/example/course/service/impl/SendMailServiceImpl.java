package com.example.course.service.impl;

import com.example.course.entity.SendMail;
import com.example.course.repository.SendMailRepository;
import com.example.course.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SendMailServiceImpl implements SendMailService {
    @Autowired
    private SendMailRepository sendMailRepository;
    @Override
    public SendMail addMail(SendMail sendMail) {
        SendMail sendMail1  = new SendMail();
        sendMail1.setId(UUID.randomUUID().toString());
        sendMail1.setTitle(sendMail.getTitle());
        sendMail1.setContent(sendMail.getContent());
        sendMail1.setType(sendMail.getType());
        return sendMailRepository.save(sendMail1) ;
    }

    @Override
    public List<SendMail> getAllMail() {
        return sendMailRepository.findAll();
    }

    @Override
    public SendMail getOneMail(String id) {
        return sendMailRepository.findById(id).orElse(null);
    }

    @Override
    public SendMail updateMail(SendMail sendMail, String id) {
        Optional<SendMail> sendMail1 = sendMailRepository.findById(id);
        if (sendMail1.isPresent()){
            SendMail sendMail2 = sendMail1.get();
            sendMail2.setTitle(sendMail.getTitle());
            sendMail2.setContent(sendMail.getContent());
            sendMail2.setType(sendMail.getType());
            return sendMailRepository.save(sendMail2) ;
        }else {
            return null;
        }
    }
}
