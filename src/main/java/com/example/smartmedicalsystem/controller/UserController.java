package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.User;
import com.example.smartmedicalsystem.service.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 患者用户 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper wrapper = new QueryWrapper();
        List<User> list= userService.list(wrapper);
        result.put("list",list);
        return objectMapper.writeValueAsString(result);
    }
    //http://localhost:8080/user?name=黄六&age=23&sex=男&phone=12345678&address=广州市海珠区&password=123456&codeid=1234
    @RequestMapping("/insertUser")
    public String insertUser(User user) throws JsonProcessingException {
        Map result = new HashMap<>();
        boolean save = userService.save(user);
        if(save){
            result.put("flag",true);
        }else{
            result.put("flag",false);
            result.put("messsage","添加失败！");
        }
        return objectMapper.writeValueAsString(result);
    }
}
