package com.insta.instadb.service.Impl;

import com.insta.instadb.entity.ScheduledMedia;
import com.insta.instadb.repository.service.ScheduledMediaRepoService;
import com.insta.instadb.service.ScheduledMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ScheduledMediaServiceImpl implements ScheduledMediaService {

    @Autowired
    private ScheduledMediaRepoService scheduledMediaRepoService;
    @Override
    public ResponseEntity<?> savePost(ScheduledMedia media) {
        return new ResponseEntity<>(scheduledMediaRepoService.addMedia(media), HttpStatus.OK);
    }
}
