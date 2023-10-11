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
@Table(name = "users")
@Getter
@Setter
//@ToString
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String userName;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String userProfile;

    @Column
    private String email;

    @Column
    private String phNo;

    @Column
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Timestamp createdDate;

    @Column
    private String gender;

    @Column
    private String dateOfBirth;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Interests> interests;

    @Column
    private String accountType;

}
