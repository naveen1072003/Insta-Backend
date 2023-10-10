package com.insta.instadb.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String mediaContent;

    @Column
    private String mediaType;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Timestamp uploadedDate;

    @ManyToOne
    private User users;

    @ManyToMany
    @JoinTable(name = "media_tags")
    private List<Interests> interests;

}
