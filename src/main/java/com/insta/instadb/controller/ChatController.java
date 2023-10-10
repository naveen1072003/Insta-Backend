package com.insta.instadb.controller;

import com.insta.instadb.api.ChatApi;
import com.insta.instadb.entity.Chats;
import com.insta.instadb.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController implements ChatApi {

    @Autowired
    private ChatService chatService;

    @Override
    public ResponseEntity<?> addMessage(@RequestBody Chats chats) {
        return chatService.saveChat(chats);
    }

    @Override
    public ResponseEntity<?> getUserChats(@PathVariable Long userId) {
        return new ResponseEntity<>(chatService.getAllUserChats(userId), HttpStatus.OK);
    }
}
