package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Chats;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatRepoService {
    Chats saveChat(Chats chats);

    List<Chats> getAllChats(Long userId);
}
