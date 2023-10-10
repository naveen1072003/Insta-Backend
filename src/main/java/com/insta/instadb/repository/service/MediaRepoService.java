package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Media;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MediaRepoService {
    Media save(Media media);

    List<Media> findMediaByUser_Id(Long userId);
}
