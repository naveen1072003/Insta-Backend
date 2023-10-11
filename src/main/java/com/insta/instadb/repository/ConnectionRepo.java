package com.insta.instadb.repository;

import com.insta.instadb.entity.Connectiondetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepo extends JpaRepository<Connectiondetails, Long> {
   Connectiondetails findByUser1_UserIdAndUser2_UserId(Long sender,Long receiver);

   Long countConnectiondetailsByUser2_UserId(Long userId);

   Long countAllByUser1_UserId(Long userId);

   List<Connectiondetails> findConnectiondetailsByUser1_UserIdAndStatus_Id(Long userId,Long statusId);
}
