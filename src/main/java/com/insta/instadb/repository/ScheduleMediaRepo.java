package com.insta.instadb.repository;

import com.insta.instadb.entity.ScheduledMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleMediaRepo extends JpaRepository<ScheduledMedia,Long> {
}
