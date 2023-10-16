package com.insta.instadb.api;

import com.insta.instadb.entity.ScheduledMedia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/v1/media")
public interface MediaApi {

    @PostMapping("/addMedia")
    ResponseEntity<?> addNewMedia(MultipartFile file,
                                  Long userId, List<String> interests) throws IOException;

//    @DeleteMapping
//    ResponseEntity<?> reomoveMedia()
    @GetMapping("/getAllMedia/{userId}")
    ResponseEntity<?> getMediaByUser(Long userId) throws IOException;

    @GetMapping("/getMediaCount/{userId}")
    ResponseEntity<?> getMediaCount(Long userId);

    @PostMapping("/addInterest/{interests}")
    ResponseEntity<?> addInterest(String interests);

    @PostMapping("/addSchedulePost")
    ResponseEntity<?> addSchedulePost(ScheduledMedia media);
}
