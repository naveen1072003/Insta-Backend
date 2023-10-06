package com.insta.instadb.repository;

import com.insta.instadb.entity.Connectiondetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepo extends JpaRepository<Connectiondetails, Long> {
   Connectiondetails findByUser1_UserIdAndUser2_UserId(Long sender,Long receiver);
}
