package com.insta.instadb.controller;

import com.insta.instadb.api.UserApi;
import com.insta.instadb.dto.LoginDTO;
import com.insta.instadb.entity.User;
import com.insta.instadb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;
    @Override
    public ResponseEntity<?> newUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveNewUser(user),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> checkUserName(@PathVariable  String name) {
        return userService.validateUserName(name);
    }

    @Override
    public ResponseEntity<?> authUser(@RequestBody LoginDTO loginDTO) {
        return userService.authorizeUser(loginDTO);
    }

    @Override
    public ResponseEntity<?> friendsList(@PathVariable Long userId) {
        return userService.getFriendsList(userId);
    }
}
