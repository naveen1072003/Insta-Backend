package com.insta.instadb.controller;

import com.insta.instadb.api.MediaApi;
import com.insta.instadb.entity.ScheduledMedia;
import com.insta.instadb.service.MediaService;
import com.insta.instadb.service.ScheduledMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
public class MediaController implements MediaApi {

    @Autowired
    private MediaService mediaService;
    @Autowired
    private ScheduledMediaService scheduledMediaService;

    @Override
    public ResponseEntity<?> addNewMedia(@RequestParam("file") MultipartFile file,
                                         @RequestParam Long userId,
                                         @RequestParam List<String> interests,
                                         @RequestParam String description,
                                         @RequestParam String scheduledTime) throws IOException, ParseException {
        return mediaService.saveMedia(file, userId, interests,description,scheduledTime);
    }

    @Override
    public ResponseEntity<?> getMediaByUser(@PathVariable Long userId) throws IOException {
        return mediaService.getMediaByUser(userId);
    }

    @Override
    public ResponseEntity<?> getMediaCount(@PathVariable Long userId) {
        return mediaService.getCount(userId);
    }

    @Override
    public ResponseEntity<?> addInterest(@PathVariable String interests) {
        System.out.println(interests);
        return mediaService.addInterests(interests);
    }

    @Override
    public ResponseEntity<?> addSchedulePost(@RequestBody ScheduledMedia media) {
        return scheduledMediaService.savePost(media);
    }
}
