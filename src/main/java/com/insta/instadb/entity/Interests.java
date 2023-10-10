package com.insta.instadb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Interests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestId;

    private String content;

}
