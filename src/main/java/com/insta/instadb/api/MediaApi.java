package com.insta.instadb.api;

import com.insta.instadb.entity.Media;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/media")
public interface MediaApi {

    @PostMapping("/addMedia")
    ResponseEntity<?> addNewMedia(Media media);

    @GetMapping("/getMedia/{userId}")
    ResponseEntity<?> getMediaByUser(Long userId);

    @PostMapping("/addInterest/{interests}")
    ResponseEntity<?> addInterest(String interests);
}
