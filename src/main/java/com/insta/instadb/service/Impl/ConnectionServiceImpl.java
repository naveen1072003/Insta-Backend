package com.insta.instadb.service.Impl;

import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.entity.Status;
import com.insta.instadb.entity.User;
import com.insta.instadb.repository.service.ConnectionRepoService;
import com.insta.instadb.repository.service.UserRepoService;
import com.insta.instadb.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    private ConnectionRepoService connectionRepoService;

    @Autowired
    private UserRepoService userRepoService;

    @Override
    public ResponseEntity<?> addRequest(Connectiondetails connectiondetails) {
        Connectiondetails follower = isFollower(connectiondetails.getUser1().getUserId(), connectiondetails.getUser2().getUserId());
        Connectiondetails isfollowing = isFollower(connectiondetails.getUser2().getUserId(), connectiondetails.getUser1().getUserId());
        User user = userRepoService.findByUserId(connectiondetails.getUser1().getUserId());
        User user1 = userRepoService.findByUserId(connectiondetails.getUser2().getUserId());
        connectiondetails.setCreatedDate(new Date());

        if (follower != null && isfollowing == null) {
            connectiondetails.setStatus(new Status(4L));
            follower.setStatus(new Status(4L));
            connectionRepoService.saveFollowRequest(follower);
            return new ResponseEntity<>(connectionRepoService.saveFollowRequest(connectiondetails), HttpStatus.OK);

        } else if (follower == null && isfollowing != null) {
            isfollowing.setStatus(new Status(4L));
            connectiondetails.setStatus(new Status(4L));
            connectionRepoService.saveFollowRequest(isfollowing);
            return new ResponseEntity<>(connectionRepoService.saveFollowRequest(connectiondetails), HttpStatus.OK);
        }
        if (isfollowing == null && follower == null) {
            if (user.getAccountType().equals("public") && user1.getAccountType().equals("private")) {
                connectiondetails.setStatus(new Status(1L));
            } else if (user.getAccountType().equals("public") && user1.getAccountType().equals("public")) {
                connectiondetails.setStatus(new Status(4L));
            } else if (user.getAccountType().equals("private") && user1.getAccountType().equals("private")) {
                connectiondetails.setStatus(new Status(1L));
            } else if (user.getAccountType().equals("private") && user1.getAccountType().equals("public")) {
                connectiondetails.setStatus(new Status(4L));
            }
        }
        return new ResponseEntity<>(connectionRepoService.saveFollowRequest(connectiondetails), HttpStatus.OK);
    }

    @Override
    public Connectiondetails isFollower(Long sender, Long receiver) {
        return connectionRepoService.findBySenderandReceiver(sender, receiver);
    }
}
