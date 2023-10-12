package com.insta.instadb.repository;

import com.insta.instadb.entity.Chats;
import com.insta.instadb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ChatRepo extends JpaRepository<Chats,Long> {

    List<Chats> findAllByUser1_UserIdOrUser2_UserId(Long id1,Long id2);

}
