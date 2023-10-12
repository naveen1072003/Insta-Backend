package com.insta.instadb.api;

import com.insta.instadb.dto.LoginDTO;
import com.insta.instadb.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/userdetails")
public interface UserApi {
    @PostMapping("/newUser")
    ResponseEntity<?> newUser(User user);
    @GetMapping("/getUser/{userId}")
    ResponseEntity<?> newUser(Long userId);
    @GetMapping("/isUser")
    ResponseEntity<?> checkUserName(String Name);

    @PostMapping("/loginAuth")
    ResponseEntity<?> authUser(LoginDTO loginDTO);

    @GetMapping("/getFriendsList/{userId}")
    ResponseEntity<?> friendsList(Long userId);
}
