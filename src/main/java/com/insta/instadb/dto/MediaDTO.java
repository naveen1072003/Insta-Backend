package com.insta.instadb.dto;

import com.insta.instadb.entity.Comments;
import com.insta.instadb.entity.Likes;
import com.insta.instadb.entity.Media;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MediaDTO {

    private Media media;

    private Long likes;

    private List<Comments> comments;


}
