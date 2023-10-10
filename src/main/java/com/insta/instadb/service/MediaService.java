package com.insta.instadb.service;

import com.insta.instadb.entity.Media;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MediaService {
    ResponseEntity<?> saveMedia(Media media);

    ResponseEntity<?> getMediaByUser(Long userId);

    ResponseEntity<?> addInterests(String interests);
}
