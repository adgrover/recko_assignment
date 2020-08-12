package com.recko.assignment.recko.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @JsonProperty("content")
    @Column(name = "content")
    private String content;

    @Column(name="timestamp")
    @JsonProperty("timestamp")
    private Date date;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "posts")
    private List<User> users;

    public Post(){}

    public Post(String content) {
        System.out.println("Post Constructor Called");
        this.content = content;
        this.date = new java.sql.Date(new java.util.Date().getTime());
    }
}
