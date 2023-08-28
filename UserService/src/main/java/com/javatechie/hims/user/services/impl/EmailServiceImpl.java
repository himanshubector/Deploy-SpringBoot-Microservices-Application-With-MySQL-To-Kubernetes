package com.javatechie.hims.user.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl
{
    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String to, String subject, String content)
    {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("notifications@example.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        javaMailSender.send(message);

    }


}
