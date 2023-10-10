package com.insta.instadb.service.Impl;

import com.insta.instadb.entity.Likes;
import com.insta.instadb.repository.service.LikesRepoService;
import com.insta.instadb.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    private LikesRepoService likesRepoService;
    @Override
    public ResponseEntity<?> saveLikes(Likes likes) {
        return new ResponseEntity<>(likesRepoService.save(likes), HttpStatus.OK);
    }

    @Override
    public Long getLikesCountByMedia(Long userId) {
        return likesRepoService.findLikesCountByMedia(userId);
    }
}
