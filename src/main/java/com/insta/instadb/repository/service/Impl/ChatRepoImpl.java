package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.dto.UserChatDTO;
import com.insta.instadb.entity.Chats;
import com.insta.instadb.entity.User;
import com.insta.instadb.repository.ChatRepo;
import com.insta.instadb.repository.service.ChatRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class ChatRepoImpl implements ChatRepoService {

    @Autowired
    private ChatRepo chatRepo;

    @Override
    public Chats saveChat(Chats chats) {
        return chatRepo.save(chats);
    }

    @Override
    public List<Chats> getAllChats(UserChatDTO userChatDTO) {
        return chatRepo.findAllByUser1_UserIdOrUser2_UserId(userChatDTO.getUser1(), userChatDTO.getUser2());
    }



}
