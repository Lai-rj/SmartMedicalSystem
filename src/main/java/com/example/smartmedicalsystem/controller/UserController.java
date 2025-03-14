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
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id) throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("id",id);
        boolean b = userService.remove(wrapper);
        if(b){
            result.put("flag",true);
        }else{
            result.put("flag",false);
            result.put("messsage","删除失败！");
        }
        return objectMapper.writeValueAsString(result);
    }
    //http://localhost:8080/user?id=11&name=黄六&age=23&sex=男&phone=123456778&address=广州市海珠区&password=123456&codeId=1234
    @RequestMapping("/updateUser")
    public String updateUser(Integer id,User user) throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",id);
        boolean b = userService.update(user,wrapper);
        if(b){
            result.put("flag",true);
        }else{
            result.put("flag",false);
            result.put("messsage","更新失败！");
        }
        return objectMapper.writeValueAsString(result);
    }
    //http:localhost:8080/user/loginUser?phone=12345678&password=123456
    @RequestMapping("/loginUser")
    public String login(String phone,String password) throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("phone",phone);
        wrapper.eq("password",password);
        User user = userService.getOne(wrapper);
        if(user!=null){
            result.put("flag",true);
            result.put("role","user");
            result.put("user",user);
        }else{
            result.put("flag",false);
            result.put("message","登录失败");
        }
        return objectMapper.writeValueAsString(result);
    }
    
    @RequestMapping("/selectById")
    public String selectById(Integer id) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<User> wrapper=new QueryWrapper();
        wrapper.eq("id",id);
        User user=userService.getOne(wrapper);
        result.put("user",user);
        return objectMapper.writeValueAsString(result);
    }


}
