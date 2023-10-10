package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.Media;
import com.insta.instadb.repository.MediaRepo;
import com.insta.instadb.repository.service.MediaRepoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MediaRepoImpl implements MediaRepoService {

    @Autowired
    private MediaRepo mediaRepo;
    @Override
    public Media save(Media media) {
        return mediaRepo.save(media);
    }

    @Override
    public List<Media> findMediaByUser_Id(Long userId) {
        return mediaRepo.findAllByUsers_UserId(userId);
    }

    @Override
    public Long findMediaCount(Long userId) {
        return mediaRepo.countAllByUsers_UserId(userId);
    }
}
