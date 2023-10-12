package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.ScheduledMedia;
import com.insta.instadb.repository.ScheduleMediaRepo;
import com.insta.instadb.repository.service.ScheduledMediaRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduledMediaRepoImpl implements ScheduledMediaRepoService {

    @Autowired
    private ScheduleMediaRepo scheduleMediaRepo;

    @Override
    public ScheduledMedia addMedia(ScheduledMedia media) {
        return scheduleMediaRepo.save(media);
    }
}
