package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.Chats;
import com.insta.instadb.repository.ChatRepo;
import com.insta.instadb.repository.service.ChatRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ChatRepoImpl implements ChatRepoService {

    @Autowired
    private ChatRepo chatRepo;

    @Override
    public Chats saveChat(Chats chats) {
        return chatRepo.save(chats);
    }

    @Override
    public List<Chats> getAllChats(Long userId) {
        return chatRepo.findAllByUser1_UserIdOrUser2_UserId(userId, userId);
    }
}
