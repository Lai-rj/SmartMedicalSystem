package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.Doctor;
import com.example.smartmedicalsystem.entity.Registration;
import com.example.smartmedicalsystem.service.IRegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 挂号帖 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private IRegistrationService registrationService;
    ObjectMapper objectMapper = new ObjectMapper();
    @RequestMapping("/add")
    //id: 0, //挂号贴编号
    //            deptId: "", //挂号科室
    //            description: "", //描述信息
    //            image: "", //描述图片文件名
    //            regisTime: "", //挂号时间
    //            docId: "", //医生
    //            userId: "", //患者
    //            status: "", //状态
    //            bookTime: "", //预约时间
    public String addRegis(int id,int deptId,String description,String image,String regisTime,int docId,int userId,int status,String bookTime) throws JsonProcessingException {
        Map result = new HashMap();
        Registration registration = new Registration();
        registration.setDiseaseType(deptId);
        registration.setDoctorId(docId);
        registration.setUserId(userId);
        registration.setDescription(description);
        registration.setStatus(status);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        registration.setRegistrationTime(LocalDateTime.parse(regisTime,formatter));
        registration.setBookTime(LocalDateTime.parse(bookTime,formatter));
        boolean flag = registrationService.save(registration);
        result.put("flag", true);
        return objectMapper.writeValueAsString(result);
    }
}
