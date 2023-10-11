package com.insta.instadb.controller;

import com.insta.instadb.api.RecommendationApi;
import com.insta.instadb.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class RecommendController implements RecommendationApi {

    @Autowired
    private RecommendService recommendService;
    @Override
    public ResponseEntity<?> reCommend(@PathVariable Long userId) {
       return recommendService.getRecommendUsers(userId);
    }

    @Override
    public ResponseEntity<?> reCommendMedia(@PathVariable Long userId) {
        return recommendService.getRecommendMedia(userId);
    }
}
