package com.example.cricket_backend.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cricket_backend.model.Notification;
import com.example.cricket_backend.service.NotificationService;



@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    public NotificationService notificationService;

    @PostMapping("/create")
    public void createNotification(@RequestBody Notification Notification){
        notificationService.createNotification(Notification);
    }

    @GetMapping("/get")
    public List<Notification> getAllNotification(){
        return notificationService.getAllNotification();
    }

    @GetMapping("/get/{id}")
    public Optional<Notification> getNotificationById(@PathVariable Long id){
        return notificationService.getNotificationById(id);
    }

    @PutMapping("/update/{id}")
    public void updateNotification(@PathVariable Long id,@RequestBody Notification Notification){
        notificationService.updateNotification(id,Notification);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteNotification(@PathVariable Long id){
        notificationService.deleteNotification(id);
    }
}

