package com.insta.instadb.api;

import com.insta.instadb.entity.Connectiondetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/request")
public interface ConnectionApi {
    @PostMapping("/followRequest")
    ResponseEntity<?> followRequest(Connectiondetails connectiondetails);

    @GetMapping("/getConnectionCount/{userId}")
    ResponseEntity<?> followersandfollwingCount(Long userId);
}
