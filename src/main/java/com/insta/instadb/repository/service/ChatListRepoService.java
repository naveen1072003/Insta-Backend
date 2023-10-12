package com.insta.instadb.repository.service;

import com.insta.instadb.entity.ChatsList;
import org.springframework.stereotype.Service;

@Service
public interface ChatListRepoService {
    ChatsList saveChatInfo(ChatsList chatsList);

    boolean checkChat(Long userId, Long userId1);
}
