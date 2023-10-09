package com.insta.instadb.repository;

import com.insta.instadb.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepo extends JpaRepository<Media, Long> {
}
