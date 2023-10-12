package com.insta.instadb.service;

import com.insta.instadb.entity.Media;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface MediaService {
    ResponseEntity<?> saveMedia(MultipartFile file, Long userId, List<String> interests) throws IOException;

    ResponseEntity<?> getMediaByUser(Long userId) throws IOException;

    ResponseEntity<?> addInterests(String interests);

    ResponseEntity<?> getCount(Long userId);
}
