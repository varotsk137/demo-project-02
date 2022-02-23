package com.example.playground.service;

import com.example.playground.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoomService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    public Room sendSimpleMail(String to, String subject, Room room){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("no-reply@icegreen.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(objectMapper.writeValueAsString(room));
        mailSender.send(message);
        log.info("Send Email to message");
        return room;

    }

}
