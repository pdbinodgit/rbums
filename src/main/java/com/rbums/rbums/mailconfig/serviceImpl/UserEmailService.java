package com.rbums.rbums.mailconfig.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserEmailService {


    @Autowired
    JavaMailSender javaMailSender;

    @Async
    public void sendMail(String to,String message){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject("Welcome to RBUMS");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }





}
