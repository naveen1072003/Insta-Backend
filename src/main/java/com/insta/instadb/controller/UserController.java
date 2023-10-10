package com.insta.instadb.controller;

import com.insta.instadb.api.UserApi;
import com.insta.instadb.entity.User;
import com.insta.instadb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;
    @Override
    public ResponseEntity<?> newUser(User user) {
        return new ResponseEntity<>(userService.saveNewUser(user),HttpStatus.OK);
    }
}
