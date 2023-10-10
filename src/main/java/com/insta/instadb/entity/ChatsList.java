package com.insta.instadb.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table
@Setter
@Getter
@ToString
public class ChatsList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user1;

    @ManyToOne
    private User user2;

    @Column
    private String avatarColor;

    @Column
    private String avatarText;

    @Column
    private String lastMessage;

    @Column
    private Date date;
}
