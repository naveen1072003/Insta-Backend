package com.insta.instadb.service.Impl;

import com.insta.instadb.dto.MediaDTO;
import com.insta.instadb.entity.Comments;
import com.insta.instadb.entity.Interests;
import com.insta.instadb.entity.Media;
import com.insta.instadb.repository.service.InterestRepoService;
import com.insta.instadb.repository.service.MediaRepoService;
import com.insta.instadb.service.CommentService;
import com.insta.instadb.service.LikesService;
import com.insta.instadb.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaRepoService mediaRepoService;

    @Autowired
    private InterestRepoService interestRepoService;

    @Autowired
    private LikesService likesService;

    @Autowired
    private CommentService commentService;

    @Override
    public ResponseEntity<?> saveMedia(Media media) {
        return new ResponseEntity<>(mediaRepoService.save(media), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getMediaByUser(Long userId) {
            List<Media> mediaList = mediaRepoService.findMediaByUser_Id(userId);
            List<MediaDTO> responseList = new ArrayList<>();
            for (Media media : mediaList) {
                List<Comments> commentsList = commentService.getCommentByMedia(media.getId());

                Long count = likesService.getLikesCountByMedia(media.getId());

                MediaDTO mediaDTO = new MediaDTO();
                mediaDTO.setMedia(media);
                mediaDTO.setLikes(count);
                mediaDTO.setComments(commentsList);

                responseList.add(mediaDTO);
            }
            return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addInterests(String interests) {
        String[] str = interests.split("\\s+");
        for (String s : str) {
            interestRepoService.save(new Interests(s));
        }
        return new ResponseEntity<>("Interest Saved!!!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getCount(Long userId) {
        return new ResponseEntity<>(mediaRepoService.findMediaCount(userId), HttpStatus.OK);
    }
}
