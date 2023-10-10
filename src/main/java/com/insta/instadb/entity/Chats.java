package com.insta.instadb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.sql.Timestamp;

@Table
@Entity
@Setter
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Chats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user1;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user2;

    @Column
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column
    private Timestamp sendDate;
}
