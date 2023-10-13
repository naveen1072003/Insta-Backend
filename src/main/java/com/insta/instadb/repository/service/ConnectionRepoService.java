package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.entity.User;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConnectionRepoService {

    Connectiondetails saveFollowRequest(Connectiondetails connectiondetails);

    Connectiondetails findBySenderandReceiver(Long sender, Long receiver);

    Long getFrCount(Long userId);

    Long getFgCount(Long userId);

    List<Connectiondetails> findFriendsList(Long userId);

    List<Connectiondetails> getAllFollowers(Long userId);
}
