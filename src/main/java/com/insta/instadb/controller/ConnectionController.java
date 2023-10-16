package com.insta.instadb.controller;

import com.insta.instadb.api.ConnectionApi;
import com.insta.instadb.dto.ConnectionDTO;
import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class ConnectionController implements ConnectionApi {

    @Autowired
    private ConnectionService connectionService;

    @Override
    public ResponseEntity<?> followRequest(@RequestBody Connectiondetails connectiondetails) {
        return connectionService.addRequest(connectiondetails);
    }

    @Override
    public ResponseEntity<?> removeFollowRequest(@RequestBody ConnectionDTO connectionDTO) {
        return connectionService.removeFollow(connectionDTO);
    }

    @Override
    public ResponseEntity<?> requestedList(@PathVariable Long userId) {
        return connectionService.getRequests(userId);
    }

    @Override
    public ResponseEntity<?> acceptedFollowRequest(@RequestBody ConnectionDTO connectionDTO) {
        return connectionService.acceptRequest(connectionDTO);
    }

    @Override
    public ResponseEntity<?> rejectedFollowRequest(@RequestBody ConnectionDTO connectionDTO) {
        return connectionService.rejectRequest(connectionDTO);
    }

    @Override
    public ResponseEntity<?> followersandfollwingCount(@PathVariable Long userId) {
        return new ResponseEntity<>(connectionService.getFollowersCount(userId) + " " +
                connectionService.getFollowingCount(userId), HttpStatus.OK);
    }
}
