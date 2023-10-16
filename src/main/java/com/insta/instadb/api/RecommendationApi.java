package com.insta.instadb.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/userRecommend")
public interface RecommendationApi {

    @GetMapping("/recommendedUsers/{userId}")
    ResponseEntity<?> reCommend(Long userId);

    @GetMapping("/recommendedMedia/{userId}")
    ResponseEntity<?> reCommendMedia(Long userId);
}
