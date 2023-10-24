package com.insta.instadb.repository;

import com.insta.instadb.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepo extends JpaRepository<Media, Long> {

    List<Media> findAllByUsers_UserId(Long userId);

    Long countAllByUsers_UserId(Long userId);

    @Query("SELECT m FROM Media m JOIN m.interests i WHERE i.interestId = :interestId")
    List<Media> findMediaByInterests(@Param("interestId") Long interestId);


}
