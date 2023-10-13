package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.entity.User;
import com.insta.instadb.repository.ConnectionRepo;
import com.insta.instadb.repository.service.ConnectionRepoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ConnectionRepoImpl implements ConnectionRepoService {

    @Autowired
    private ConnectionRepo connectionRepo;
    @Override
    public Connectiondetails saveFollowRequest(Connectiondetails connectiondetails) {
        return connectionRepo.save(connectiondetails);
    }

    @Override
    public Connectiondetails findBySenderandReceiver(Long sender, Long receiver) {
        return connectionRepo.findByUser1_UserIdAndUser2_UserId(sender,receiver);
    }

    @Override
    public Long getFrCount(Long userId) {
        return connectionRepo.countConnectiondetailsByUser2_UserId(userId);
    }

    @Override
    public Long getFgCount(Long userId) {
        return connectionRepo.countAllByUser1_UserId(userId);
    }

    @Override
    public List<Connectiondetails> findFriendsList(Long userId) {
        return connectionRepo.findConnectiondetailsByUser1_UserIdAndStatus_Id(userId,4L);
    }

    @Override
    public List<Connectiondetails> getAllFollowers(Long userId) {
        return connectionRepo.findConnectiondetailsByUser2_UserId(userId);
    }
}
