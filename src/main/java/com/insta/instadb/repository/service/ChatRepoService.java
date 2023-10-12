package com.insta.instadb.repository.service;

import com.insta.instadb.dto.UserChatDTO;
import com.insta.instadb.entity.Chats;
import com.insta.instadb.entity.User;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ChatRepoService {
    Chats saveChat(Chats chats);

    List<Chats> getAllChats(UserChatDTO userChatDTO);


}
