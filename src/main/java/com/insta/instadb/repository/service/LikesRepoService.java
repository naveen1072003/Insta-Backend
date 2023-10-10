package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Likes;
import com.insta.instadb.service.LikesService;
import org.springframework.stereotype.Service;

@Service
public interface LikesRepoService {
    Likes save(Likes likes);

    Long findLikesCountByMedia(Long userId);
}
