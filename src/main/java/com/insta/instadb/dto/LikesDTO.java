package com.insta.instadb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikesDTO {

    private Long mediaId;
    private Long userId;
}
