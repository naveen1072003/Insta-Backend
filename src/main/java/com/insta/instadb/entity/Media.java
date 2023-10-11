package com.insta.instadb.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
