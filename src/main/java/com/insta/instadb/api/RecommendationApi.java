package com.insta.instadb.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/")
public interface RecommendationApi {

    @GetMapping("/recommend")
    void reCommend();
}
