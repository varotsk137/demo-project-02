package com.example.playground.controller;

import com.example.playground.job.ScheduleRandomNumberJob;
import com.example.playground.model.Room;
import com.example.playground.service.RoomService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    private static final String EMAIL = "xxxxxxx@gmail.com";
    private static final String SUBJECT = "Test send email to this mail naa";

    @Autowired
    private RoomService roomService;

    @PostMapping(value = "")
    public Room testSendEmail(@Validated @RequestBody Room room){
        return roomService.sendSimpleMail(EMAIL, SUBJECT, room);
    }

    @PostMapping(value = "/theme")
    public void testThemeEmail(@Validated @RequestBody Room room){
        roomService.sendThymeleafThemedMail(EMAIL, SUBJECT, room);
    }
}
