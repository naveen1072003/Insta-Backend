package com.insta.instadb.controller;

import com.insta.instadb.api.ChatApi;
import com.insta.instadb.dto.UserChatDTO;
import com.insta.instadb.entity.Chats;
import com.insta.instadb.service.ChatListService;
import com.insta.instadb.service.ChatService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ChatController implements ChatApi {

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatListService chatListService;

    @Override
    public ResponseEntity<?> addMessage(Chats chats,HttpServletRequest httpServletRequest) {
        System.out.println(chats);

        String authorizationHeader = httpServletRequest.getHeader("Authorization");

        // Token might look like 'Bearer <actual_token_value>'
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7); // Remove "Bearer " prefix
            System.out.println(token);
        } else {
            System.out.println("No token provided in the request headers");
        }

        return chatService.saveChat(chats);
    }

    @Override
    public ResponseEntity<?> getUserChatList(Long userId) {
        return chatListService.getChatList(userId);
    }

    @Override
    public ResponseEntity<?> getUserChats(UserChatDTO userChatDTO) {
        return new ResponseEntity<>(chatService.getAllUserChats(userChatDTO), HttpStatus.OK);
    }
}
