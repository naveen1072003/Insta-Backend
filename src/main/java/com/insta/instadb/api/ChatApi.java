package com.insta.instadb.api;

import com.insta.instadb.entity.Chats;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/message")
public interface ChatApi {

    @PostMapping("/addChat")
    ResponseEntity<?> addMessage(Chats chats);

    @GetMapping("getChats/{userId}")
    ResponseEntity<?> getUserChats(Long userId);
}
