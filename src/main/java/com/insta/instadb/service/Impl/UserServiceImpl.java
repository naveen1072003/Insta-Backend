package com.insta.instadb.service.Impl;

import com.insta.instadb.entity.User;
import com.insta.instadb.repository.service.UserRepoService;
import com.insta.instadb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepoService userRepoService;


     @Override
    public ResponseEntity<?> saveNewUser(User user) {
         if (checkIfUser(user.getEmail())){
             return new ResponseEntity<>(user.getUserName(), HttpStatus.BAD_REQUEST);
         }
         else{
             user.setCreatedDate(new Date());
             return new ResponseEntity<>(userRepoService.save(user),HttpStatus.OK);
         }
    }

    @Override
    public boolean checkIfUser(String email) {
       User user = userRepoService.findUserByEmail(email);
        return user != null;
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return Optional.ofNullable(userRepoService.findByUserId(userId));
    }
}
