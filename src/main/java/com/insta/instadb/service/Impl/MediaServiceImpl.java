package com.insta.instadb.service.Impl;

import com.insta.instadb.entity.Interests;
import com.insta.instadb.entity.Media;
import com.insta.instadb.repository.service.InterestServiceRepo;
import com.insta.instadb.repository.service.MediaRepoService;
import com.insta.instadb.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MediaServiceImpl implements MediaService {

     @Autowired
     private MediaRepoService mediaRepoService;

     @Autowired
     private InterestServiceRepo interestServiceRepo;

    @Override
    public ResponseEntity<?> saveMedia(Media media) {
        return new ResponseEntity<>(mediaRepoService.save(media), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getMediaByUser(Long userId) {
        return new ResponseEntity<>(mediaRepoService.findMediaByUser_Id(userId),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addInterests(String interests) {
        String[] str = interests.split("\\s+");
        for (String s:str) {
            interestServiceRepo.save(new Interests(s));
        }
        return new ResponseEntity<>("Interest Saved!!!",HttpStatus.OK);
    }
}
