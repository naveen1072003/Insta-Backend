package com.insta.instadb.service;

import com.insta.instadb.entity.Connectiondetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ConnectionService {
    ResponseEntity<?> addRequest(Connectiondetails connectiondetails);

    Connectiondetails isFollower(Long sender,Long receiver);
}
