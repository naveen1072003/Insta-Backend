package com.insta.instadb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String userName;

    @Column
    private String userProfile;

    @Column
    private String email;

    @Column
    private String phNo;

    @Column
    private String password;

    @Column
    private Date createdDate;

    @Column
    private String accountType;

}
