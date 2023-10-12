package com.insta.instadb.service.Impl;

import com.insta.instadb.dto.MediaDTO;
import com.insta.instadb.entity.Comments;
import com.insta.instadb.entity.Interests;
import com.insta.instadb.entity.Media;
import com.insta.instadb.entity.User;
import com.insta.instadb.repository.service.InterestRepoService;
import com.insta.instadb.repository.service.MediaRepoService;
import com.insta.instadb.service.CommentService;
import com.insta.instadb.service.LikesService;
import com.insta.instadb.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    String FOLDER_PATH = "/home/divum/IdeaProjects/InstaDB/src/main/resources/static/";
    @Override
    public ResponseEntity<?> saveMedia(MultipartFile file,Long userId,List<String> interests) throws IOException {
        System.out.println(interests);
        List<Interests> interestsList = new ArrayList<>();

        for (int i = 0; i < interests.size(); i++) {
            interestsList.add(interestRepoService.getInterestbyName(interests.get(i)));
        }

        String filePath = FOLDER_PATH + file.getOriginalFilename();
        Media media = new Media(file.getOriginalFilename(),file.getContentType(),new User(userId),interestsList);
        file.transferTo(new File(filePath));
        return new ResponseEntity<>(mediaRepoService.save(media), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getMediaByUser(Long userId) throws IOException {
            List<Media> mediaList = mediaRepoService.findMediaByUser_Id(userId);
            List<MediaDTO> responseList = new ArrayList<>();
            for (Media media : mediaList) {
                List<Comments> commentsList = commentService.getCommentByMedia(media.getId());

                Long count = likesService.getLikesCountByMedia(media.getId());

                MediaDTO mediaDTO = new MediaDTO();
                mediaDTO.setMediaContent("http://localhost:8080/"+media.getMediaPath());
                mediaDTO.setMediaType(media.getMediaType());
                mediaDTO.setUploadedDate(media.getUploadedDate());
                mediaDTO.setTags(media.getInterests());
                mediaDTO.setUsers(media.getUsers());
                mediaDTO.setLikes(count);
                mediaDTO.setComments(commentsList);

                responseList.add(mediaDTO);
            }
        return new ResponseEntity<>(responseList,HttpStatus.OK);
//            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpeg")).body(responseList.get(0).getMediaContent());
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
