package com.example.cricket_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket_backend.model.Notification;
import com.example.cricket_backend.repository.NotificationRepository;

@Service
public class NotificationService {
    @Autowired
    public NotificationRepository notificationRepository;

    public void createNotification(Notification notification){
        notificationRepository.save(notification);
    }

    public List<Notification> getAllNotification(){
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id){
        return notificationRepository.findById(id);
    }

    public void updateNotification(Long id,Notification notification){
        if(notificationRepository.existsById(id)){
            notificationRepository.save(notification);
        }
    }
    public void deleteNotification(Long id){
        notificationRepository.deleteById(id);
    }
    

}
