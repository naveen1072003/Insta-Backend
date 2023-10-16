package com.insta.instadb.repository;

import com.insta.instadb.dto.ConnectionDTO;
import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConnectionRepo extends JpaRepository<Connectiondetails, Long> {
    Connectiondetails findBySender_UserIdAndReceiver_UserId(Long sender, Long receiver);

    Long countConnectiondetailsByReceiver_UserId(Long userId);

    Long countAllBySender_UserId(Long userId);

    List<Connectiondetails> findConnectiondetailsByReceiver_UserId(Long userId);

    List<Connectiondetails> findConnectiondetailsBySender_UserIdAndStatus_Id(Long userId, Long statusId);

    void deleteConnectiondetailsBySenderUserIdAndReceiverUserId(Long user1, Long user2);
}
