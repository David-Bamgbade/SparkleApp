package com.SparkleApp.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("spring.mail.username.")
    private String fromMail;

    public void sendEmail(String mail, String email, String body){
        SimpleMailMessage  mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail);
        mailMessage.setSubject(email);
        mailMessage.setText(body);
        javaMailSender.send(mailMessage);
    }


}
