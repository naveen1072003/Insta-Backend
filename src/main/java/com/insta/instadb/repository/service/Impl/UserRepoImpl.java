package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.User;
import com.insta.instadb.repository.UserRepo;
import com.insta.instadb.repository.service.UserRepoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRepoImpl implements UserRepoService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User findByUserId(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User isUserNamePresent(String name) {
        return userRepo.findByUserName(name);
    }


}
