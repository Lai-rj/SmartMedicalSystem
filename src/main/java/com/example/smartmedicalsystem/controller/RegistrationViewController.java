package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.Registration;
import com.example.smartmedicalsystem.entity.RegistrationView;
import com.example.smartmedicalsystem.service.IRegistrationViewService;
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
 * VIEW 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-18
 */
@RestController
@RequestMapping("/registrationView")
public class RegistrationViewController {
    @Autowired
    private IRegistrationViewService registrationViewService;
    ObjectMapper objectMapper = new ObjectMapper();
    @RequestMapping("/queryByUser")
    public String queryByUser(int userId) throws JsonProcessingException {
        Map result = new HashMap();
        QueryWrapper<RegistrationView> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        List<RegistrationView> list = registrationViewService.list(wrapper);
        result.put("list",list);
        result.put("flag",true);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/queryByDoctor")
    public String queryByDoctor(int doctorId) throws JsonProcessingException {
        Map result = new HashMap();
        QueryWrapper<RegistrationView> wrapper = new QueryWrapper<>();
        wrapper.eq("doctor_id",doctorId);
        List<RegistrationView> list = registrationViewService.list(wrapper);
        result.put("list",list);
        result.put("flag",true);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result = new HashMap();
        List<RegistrationView> list = registrationViewService.list();
        result.put("list",list);
        result.put("flag",true);
        return objectMapper.writeValueAsString(result);
    }
}
