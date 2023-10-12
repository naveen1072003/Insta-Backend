package com.insta.instadb.repository.service;

import com.insta.instadb.entity.ScheduledMedia;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
public interface ScheduledMediaRepoService {
    ScheduledMedia addMedia(ScheduledMedia media);
}
