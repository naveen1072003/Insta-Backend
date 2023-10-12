package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Chats;
import com.insta.instadb.entity.ChatsList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ChatListRepoService {
    ChatsList saveChatInfo(ChatsList chatsList);

    boolean checkChat(Long userId, Long userId1);
    List<ChatsList> getUserChatList(Long userId);
}
