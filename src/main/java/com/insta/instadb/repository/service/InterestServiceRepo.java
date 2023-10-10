package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Interests;
import org.springframework.stereotype.Service;

@Service
public interface InterestServiceRepo {

    void save(Interests interests);
}
