package com.insta.instadb.api;

import com.insta.instadb.dto.UserChatDTO;
import com.insta.instadb.entity.Chats;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/api/v1/message")
public interface ChatApi {

    @PostMapping("/addChat")
    ResponseEntity<?> addMessage(Chats chats);

    @GetMapping("/getChats")
    ResponseEntity<?> getUserChats(UserChatDTO chatDTO);

    @GetMapping("/getChatList/{userId}")
    ResponseEntity<?> getUserChatList(Long userId);
}
