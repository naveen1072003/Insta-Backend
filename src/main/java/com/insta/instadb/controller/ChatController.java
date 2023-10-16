package com.insta.instadb.controller;

import com.insta.instadb.api.ChatApi;
import com.insta.instadb.dto.UserChatDTO;
import com.insta.instadb.entity.Chats;
import com.insta.instadb.service.ChatListService;
import com.insta.instadb.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ChatController implements ChatApi {

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatListService chatListService;

    @Override
    public ResponseEntity<?> addMessage(@RequestBody Chats chats) {
        return chatService.saveChat(chats);
    }

    @Override
    public ResponseEntity<?> getUserChatList(@PathVariable Long userId) {
        return chatListService.getChatList(userId);
    }

    @Override
    public ResponseEntity<?> getUserChats(@RequestBody UserChatDTO userChatDTO) {
        return new ResponseEntity<>(chatService.getAllUserChats(userChatDTO), HttpStatus.OK);
    }
}
