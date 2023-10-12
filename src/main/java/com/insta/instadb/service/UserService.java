package com.insta.instadb.service;

import com.insta.instadb.dto.LoginDTO;
import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    ResponseEntity<?> saveNewUser(User user);

    boolean checkIfUser(String email);

    Optional<User> findUserById(Long userId);

    ResponseEntity<?> validateUserName(String name);

    ResponseEntity<?> authorizeUser(LoginDTO loginDTO);

    ResponseEntity<?> getFriendsList(Long userId);

    ResponseEntity<?> getUser(Long userId);
}
