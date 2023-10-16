package com.insta.instadb.service.Impl;

import com.insta.instadb.auth.JwtService;
import com.insta.instadb.auth.UserDetailsInfo;
import com.insta.instadb.dto.LoginDTO;
import com.insta.instadb.dto.UpdateUserDTO;
import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.entity.User;
import com.insta.instadb.repository.service.UserRepoService;
import com.insta.instadb.service.ConnectionService;
import com.insta.instadb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepoService userRepoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ConnectionService connectionService;

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
    public ResponseEntity<?> updateUserDetails(UpdateUserDTO updateUserDTO) {
        User user = userRepoService.getUserById(updateUserDTO.getUserDTO().getUserId()).get();
        user.setDateOfBirth(updateUserDTO.getUserDTO().getDateOfBirth());
        user.setFirstName(updateUserDTO.getUserDTO().getFirstName());
        user.setLastName(updateUserDTO.getUserDTO().getLastName());
        user.setPhNo(updateUserDTO.getUserDTO().getPhNo());
        return new ResponseEntity<>(userRepoService.save(user), HttpStatus.OK);
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
        if (user != null) {
            return new ResponseEntity<>("Username already exists", HttpStatus.OK);
        }
        return new ResponseEntity<>("Valid Username", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> authorizeUser(LoginDTO loginDTO) {
        Optional<User> customerDetails = userRepoService.findUserByEmail(loginDTO.getEmail());

        if (customerDetails.isEmpty()) {
            return ResponseEntity.ok("User does not exist!");
        } else {
            if (passwordEncoder.matches(loginDTO.getPassword(), customerDetails.get().getPassword())) {
                return new ResponseEntity<>(jwtService.generateToken(loginDTO.getEmail()), HttpStatus.OK);
            }
            return new ResponseEntity<>("You have entered wrong password", HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity<?> getFriendsList(Long userId) {
        List<Connectiondetails> mutual = connectionService.findFriends(userId);

        List<User> userList = new ArrayList<>();
        for (Connectiondetails connectiondetails : mutual) {
            userList.add(userRepoService.findByUserId(connectiondetails.getReceiver().getUserId()));
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUser(Long userId) {
        return new ResponseEntity<>(userRepoService.getUserById(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> removeAccount(Long userId) {
        userRepoService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted Successfully!!!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> Oauthorize(String email) {
        Optional<User> user = userRepoService.findUserByEmail(email);
        if (user.isPresent()) {
            return new ResponseEntity<>(jwtService.generateToken(email), HttpStatus.OK);
        }
        return new ResponseEntity<>(user, HttpStatus.UNAUTHORIZED);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userDetail = userRepoService.findUserByEmail(email);

        // Converting userDetail to UserDetails
        return userDetail.map(UserDetailsInfo::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + email));
    }
}
