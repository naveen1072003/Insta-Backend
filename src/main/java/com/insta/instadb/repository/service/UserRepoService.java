package com.insta.instadb.repository.service;

import com.insta.instadb.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepoService {
    User save(User user);

    Optional<User> findUserByEmail(String email);

    User findByUserId(Long id);

    User isUserNamePresent(String name);

}
