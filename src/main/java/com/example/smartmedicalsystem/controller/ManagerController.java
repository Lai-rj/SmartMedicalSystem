package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.Doctor;
import com.example.smartmedicalsystem.entity.Manager;
import com.example.smartmedicalsystem.entity.User;
import com.example.smartmedicalsystem.service.IManagerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private IManagerService managerService;
    ObjectMapper objectMapper =new ObjectMapper();
    @RequestMapping("/loginManager")
    public String login(String name,String password) throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",name);
        wrapper.eq("password",password);
        Manager manager = managerService.getOne(wrapper);
        if(manager!=null){
            result.put("flag",true);
            result.put("role","manager");
            result.put("user",manager);
        }else{
            result.put("flag",false);
            result.put("message","登录失败");
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/selectById")
    public String selectById(Integer id) throws JsonProcessingException {
        Map result = new HashMap();
        QueryWrapper<Manager> wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        Manager manager = managerService.getOne(wrapper);
        result.put("user",manager);
        return objectMapper.writeValueAsString(result);
    }
}
