package com.insta.instadb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonIgnore
    private Long userId;


    private String userName;


    private String firstName;


    private String lastName;


    private String userProfile;


    private String email;


    private String phNo;

//    @JsonIgnore
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Timestamp createdDate;


    private String gender;


    private String dateOfBirth;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Interests> interests;


    private String accountType;

    public User(Long userId) {
        this.userId = userId;
    }
}
