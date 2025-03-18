package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.Hospital;
import com.example.smartmedicalsystem.entity.Posts;
import com.example.smartmedicalsystem.service.impl.HospitalServiceImpl;
import com.example.smartmedicalsystem.service.impl.PostsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 问诊记录 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostsServiceImpl postsService;
    ObjectMapper objectMapper=new ObjectMapper();
    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper<Posts> wrapper = new QueryWrapper();
        List<Posts> list= postsService.list(wrapper);
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/selectByPublisherId?publisher=23
    @RequestMapping("/selectByPublisherId")
    public String selectByPublisherId(Integer publisher) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Posts> wrapper=new QueryWrapper();
        wrapper.eq("publisher",publisher);
        List<Posts> list=postsService.list(wrapper);
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/selectByRegistrationId?publisher=3&registrationId=22
    @RequestMapping("/selectByRegistrationId")
    public String selectByPublisherId(Integer publisher,Integer registrationId) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Posts> wrapper=new QueryWrapper();
        wrapper.eq("publisher",publisher);
        wrapper.eq("registration_id",registrationId);
        List<Posts> list=postsService.list(wrapper);
        if(list!=null && !list.isEmpty()){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/managerAddPosts")
    public String managerAddPosts(Posts posts) throws JsonProcessingException {
        // 创建 Date 对象表示当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        posts.setCreateTime(currentTime);
        Map result=new HashMap();
        int count= postsService.managerAddPosts(posts);
        if(count>0){
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }
}
