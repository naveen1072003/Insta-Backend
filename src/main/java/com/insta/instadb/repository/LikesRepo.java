package com.insta.instadb.repository;

import com.insta.instadb.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepo extends JpaRepository<Likes, Long> {

    Long countLikesByMedia_Id(Long mediaId);
}
