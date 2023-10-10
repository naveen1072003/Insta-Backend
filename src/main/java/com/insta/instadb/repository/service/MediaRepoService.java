package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Media;
import org.springframework.stereotype.Service;

@Service
public interface MediaRepoService {

    Media save(Media media);
}
