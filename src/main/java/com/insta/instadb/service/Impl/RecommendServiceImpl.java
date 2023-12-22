package com.insta.instadb.service.Impl;

import com.insta.instadb.dto.MediaDTO;
import com.insta.instadb.entity.Interests;
import com.insta.instadb.entity.Media;
import com.insta.instadb.entity.User;
import com.insta.instadb.repository.service.CommentRepoService;
import com.insta.instadb.repository.service.LikesRepoService;
import com.insta.instadb.repository.service.MediaRepoService;
import com.insta.instadb.service.ConnectionService;
import com.insta.instadb.service.RecommendService;
import com.insta.instadb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private UserService userService;

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private MediaRepoService mediaRepoService;

    @Autowired
    private LikesRepoService likesRepoService;

    @Autowired
    private CommentRepoService commentRepoService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<?> getRecommendUsers(Long userId) {
        String url = "http://localhost:5005/recommendation/recommended-friends/" + userId;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Accept", "application/json") // Set Accept header if expecting JSON response
                .build();
        String users = "";
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            users = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        users = users.replaceAll("\"", "");
        String[] str = users.substring(1, users.length() - 2).split(",");
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            Long id = Long.parseLong(str[i].replaceAll("\\s+", ""));
            User user = userService.findUserById(id).get();
            if (connectionService.isFollower(userId, user.getUserId()).getBody() == null && !Objects.equals(user.getUserId(), userId)) {
                userList.add(user);
            }
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getRecommendMedia(Long userId) {
        String url = "http://localhost:5005/recommendation/recommended-interests/" + userId;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Accept", "application/json") // Set Accept header if expecting JSON response
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Media> mediaList = mediaRepoService.getAllMedia();

        User user = userService.findUserById(userId).get();
        StringBuilder userInterest = new StringBuilder();
        for (Interests interests : user.getInterests()) {
            userInterest.append(interests.getContent()).append(" ");
        }
        String inter = userInterest.toString();
        List<MediaDTO> responsemediaList = new ArrayList<>();
        for (Media media1 : mediaList) {

            if (media1.getUsers().getUserId() != userId) {
                for (Interests interests : media1.getInterests()) {
                    if (inter.contains(interests.getContent())) {
                        MediaDTO mediaDTO = new MediaDTO();
                        modelMapper.map(media1, mediaDTO);
                        mediaDTO.setComments(commentRepoService.getComment(media1.getId()));
                        mediaDTO.setLiked(likesRepoService.isLiked(media1.getId(), userId));
                        mediaDTO.setLikes(likesRepoService.findLikesCountByMedia(media1.getId()));
                        if (!responsemediaList.contains(mediaDTO))
                            responsemediaList.add(mediaDTO);
                    }
                }
            }
        }
        return new ResponseEntity<>(responsemediaList, HttpStatus.OK);
    }
}
