package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.repository.ConnectionRepo;
import com.insta.instadb.repository.service.ConnectionRepoService;
import org.springframework.beans.factory.annotation.Autowired;

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

}
