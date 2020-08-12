package com.recko.assignment.recko.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @JsonProperty("user_id")
    @Column(name = "id")
    private String userId;

    @JsonProperty("user_name")
    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    @JsonProperty("password")
    private String password;

//    @JsonProperty("subscriber_list")
//    private List<User> subscriberList;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "user_posts",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "post_id")}
    )
    private List<Post> posts;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<User> getSubscriberList() {
//        return subscriberList;
//    }
//
//    public void setSubscriberList(List<User> subscriberList) {
//        this.subscriberList = subscriberList;
//    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
