package com.recko.assignment.recko.controller;

import com.recko.assignment.recko.entity.Post;
import com.recko.assignment.recko.service.ReckoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReckoController {

    @Autowired
    public ReckoService reckoService;

    @PostMapping(value = "/user/addpost")
    public void addUserPost(@RequestHeader("userid") String userId, @RequestBody Post post){

        reckoService.addUserPost(userId, post);
    }

    @GetMapping(value = "/user/posts")
    public void viewUserPosts(@RequestHeader("userId") String userId){
        List<Post> posts = reckoService.viewUserPosts(userId);
    }
}
