package com.insta.instadb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ScheduledMedia {
    @Id
    @GeneratedValue
    private Long id;

    private String mediaPath;
    private String mediaType;
    private Date scheduledTime;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Timestamp createdTime;

}
