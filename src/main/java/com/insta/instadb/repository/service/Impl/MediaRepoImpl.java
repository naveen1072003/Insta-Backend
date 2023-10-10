package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.Media;
import com.insta.instadb.repository.MediaRepo;
import com.insta.instadb.repository.service.MediaRepoService;
import org.springframework.beans.factory.annotation.Autowired;

public class MediaRepoImpl implements MediaRepoService {

    @Autowired
    private MediaRepo mediaRepo;
    @Override
    public Media save(Media media) {
        return mediaRepo.save(media);
    }
}
