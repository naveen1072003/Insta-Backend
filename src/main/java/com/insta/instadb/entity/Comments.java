package com.insta.instadb.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Data
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comId;

    @Column
    private String commentContent;

    @ManyToOne
    private Media media;

    @ManyToOne
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column
    private Timestamp timestamp;
}
