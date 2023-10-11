package com.insta.instadb.service;

import com.insta.instadb.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecommendService {
    ResponseEntity<?> getRecommendUsers(Long userId);

    ResponseEntity<?> getRecommendMedia(Long userId);
}
