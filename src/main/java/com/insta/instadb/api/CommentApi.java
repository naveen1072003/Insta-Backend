package com.insta.instadb.api;

import com.insta.instadb.entity.Comments;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@CrossOrigin
@RequestMapping("/api/v1/comments")
public interface CommentApi {
    @PostMapping("/addComments")
    ResponseEntity<?> addComment(@RequestBody Comments comments);

}
