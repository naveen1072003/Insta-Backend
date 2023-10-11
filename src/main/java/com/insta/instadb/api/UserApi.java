package com.insta.instadb.api;

import com.insta.instadb.dto.LoginDTO;
import com.insta.instadb.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/userdetails")
public interface UserApi {
    @PostMapping("/newUser")
    ResponseEntity<?> newUser(@RequestBody User user);

    @GetMapping("/isUser")
    ResponseEntity<?> checkUserName(String Name);

    @PostMapping("/loginAuth")
    ResponseEntity<?> authUser(LoginDTO loginDTO);
}
