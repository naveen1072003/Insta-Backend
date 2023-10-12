package com.insta.instadb.service;

import com.insta.instadb.entity.ScheduledMedia;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ScheduledMediaService {
    ResponseEntity<?> savePost(ScheduledMedia media);
}
