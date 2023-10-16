package com.insta.instadb.controller;

import com.insta.instadb.api.NotificationApi;
import com.insta.instadb.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class NotificationController implements NotificationApi {

    @Autowired
    private NotificationService notificationService;

    @Override
    public ResponseEntity<?> getNotificationforUser(@PathVariable Long userId) {
        return notificationService.getNotifications(userId);
    }
}
