package com.insta.instadb.controller;

import com.insta.instadb.api.MediaApi;
import com.insta.instadb.entity.Media;
import com.insta.instadb.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MediaController implements MediaApi {

    @Autowired
    private MediaService mediaService;

    @Override
    public ResponseEntity<?> addNewMedia(@RequestBody Media media) {
        return mediaService.saveMedia(media);
    }

    @Override
    public ResponseEntity<?> getMediaByUser(@PathVariable Long userId) {
        System.out.println(userId);
        return mediaService.getMediaByUser(userId);
    }

    @Override
    public ResponseEntity<?> addInterest(@PathVariable String interests) {
        System.out.println(interests);
        return mediaService.addInterests(interests);
    }
}
