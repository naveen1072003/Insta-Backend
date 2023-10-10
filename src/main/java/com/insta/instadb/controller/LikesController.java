package com.insta.instadb.controller;

import com.insta.instadb.api.LikesApi;
import com.insta.instadb.entity.Likes;
import com.insta.instadb.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikesController implements LikesApi {

    @Autowired
    private LikesService likesService;
    @Override
    public ResponseEntity<?> addLike(@RequestBody Likes likes) {
        return likesService.saveLikes(likes);
    }
}
