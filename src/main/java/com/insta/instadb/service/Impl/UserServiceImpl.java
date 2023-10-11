package com.insta.instadb.service.Impl;

import com.insta.instadb.auth.JwtService;
import com.insta.instadb.auth.UserDetailsInfo;
import com.insta.instadb.dto.LoginDTO;
import com.insta.instadb.entity.User;
import com.insta.instadb.repository.service.UserRepoService;
import com.insta.instadb.service.UserService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepoService userRepoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Override
    public ResponseEntity<?> saveNewUser(User user) {
        if (checkIfUser(user.getEmail())) {
            return new ResponseEntity<>(user.getUserName(), HttpStatus.BAD_REQUEST);
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return new ResponseEntity<>(userRepoService.save(user), HttpStatus.OK);
        }
    }

    @Override
    public boolean checkIfUser(String email) {
        Optional<User> user = userRepoService.findUserByEmail(email);
        return user.isPresent();
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return Optional.ofNullable(userRepoService.findByUserId(userId));
    }

    @Override
    public ResponseEntity<?> validateUserName(String name) {
        User user = userRepoService.isUserNamePresent(name);
        if(user != null){
            return new ResponseEntity<>("Username already exists",HttpStatus.OK);
        }
        return new ResponseEntity<>("Valid Username", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> authorizeUser(LoginDTO loginDTO) {
        Optional<User> customerDetails = userRepoService.findUserByEmail(loginDTO.getEmail());

        if(customerDetails.isEmpty()){
            return ResponseEntity.ok("User does not exist!");
        }
        else {
            if (passwordEncoder.matches(loginDTO.getPassword(), customerDetails.get().getPassword())) {
                return new ResponseEntity<>(jwtService.generateToken(loginDTO.getEmail()),HttpStatus.OK);
            }
            return new ResponseEntity<>("You have entered wrong password",HttpStatus.NO_CONTENT);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userDetail = userRepoService.findUserByEmail(email);

        // Converting userDetail to UserDetails
        return userDetail.map(UserDetailsInfo::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + email));
    }
}
