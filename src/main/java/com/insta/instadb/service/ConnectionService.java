package com.insta.instadb.service;

import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConnectionService {
    ResponseEntity<?> addRequest(Connectiondetails connectiondetails);

    Connectiondetails isFollower(Long sender,Long receiver);

    Long getFollowersCount(Long userId);
    Long getFollowingCount(Long userId);

    List<Connectiondetails> findFriends(Long userId);
}
