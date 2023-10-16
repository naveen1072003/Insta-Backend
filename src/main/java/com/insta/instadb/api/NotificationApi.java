package com.insta.instadb.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/api/v1/notifyUser")
public interface NotificationApi {
    @GetMapping("/getNotifications/{userId}")
    ResponseEntity<?> getNotificationforUser(Long userId);
}
