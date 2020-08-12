package com.recko.assignment.recko.service;

import com.recko.assignment.recko.entity.Post;
import com.recko.assignment.recko.entity.User;
import com.recko.assignment.recko.repository.ReckoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReckoService {

    @Autowired
    public ReckoRepository reckoRepository;

    private static SessionFactory sessionFactory;
    private Session session;

    public void addUserPost(String userId, Post post){
        User user = reckoRepository.findUser(userId);
        user.getPosts().add(post);

        session.persist(user);
    }

    public List<Post> viewUserPosts(String userId){
        User user = reckoRepository.findUser(userId);

        return user.getPosts();
    }
}
