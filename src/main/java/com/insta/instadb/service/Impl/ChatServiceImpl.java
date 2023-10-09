package com.insta.instadb.service.Impl;

import com.insta.instadb.entity.Chats;
import com.insta.instadb.repository.service.ChatRepoService;
import com.insta.instadb.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepoService chatRepoService;

    @Override
    public ResponseEntity<?> saveChat(Chats chats) {
        return new ResponseEntity<>(chatRepoService.saveChat(chats), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllUserChats(Long userId) {
        return new ResponseEntity<>(chatRepoService.getAllChats(userId), HttpStatus.OK);
    }
}
