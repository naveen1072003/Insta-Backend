package com.insta.instadb.controller;

import com.insta.instadb.api.MediaApi;
import com.insta.instadb.entity.Media;
import com.insta.instadb.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class MediaController implements MediaApi {

    @Autowired
    private MediaService mediaService;

    @Override
    public ResponseEntity<?> addNewMedia(@RequestParam("file") MultipartFile file,
                                         @RequestParam Long userId,
                                         @RequestParam List<String> interests) throws IOException {
        return mediaService.saveMedia(file,userId,interests);
    }

    @Override
    public ResponseEntity<?> getMediaByUser(@PathVariable Long userId) throws IOException {
        System.out.println(userId);
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
}
