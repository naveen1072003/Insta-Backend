package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.Interests;
import com.insta.instadb.repository.InterestRepo;
import com.insta.instadb.repository.service.InterestServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestImpl implements InterestServiceRepo {

    @Autowired
    private InterestRepo interestRepo;
    @Override
    public void save(Interests interests) {
        interestRepo.save(interests);
    }
}
