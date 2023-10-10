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
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String mediaContent;

    @Column
    private String mediaType;

    @Column
    private Date date;

}
