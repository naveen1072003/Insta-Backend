package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Connectiondetails;
import org.springframework.stereotype.Service;

@Service
public interface ConnectionRepoService {

    Connectiondetails saveFollowRequest(Connectiondetails connectiondetails);

    Connectiondetails findBySenderandReceiver(Long sender, Long receiver);
}
