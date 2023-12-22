package com.insta.instadb.service;

import com.insta.instadb.dto.LikesDTO;
import com.insta.instadb.entity.Likes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LikesService {

    ResponseEntity<?> saveLikes(LikesDTO likes);

    Long getLikesCountByMedia(Long userId);
}
