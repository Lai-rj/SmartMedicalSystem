package com.example.smartmedicalsystem.controller;


import com.example.smartmedicalsystem.entity.Doctor;
import com.example.smartmedicalsystem.service.impl.DoctorServiceImpl;
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
 * 医生 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorServiceImpl doctorService;
    ObjectMapper objectMapper=new ObjectMapper();

    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result=new HashMap();
        List<Doctor> list=doctorService.list();
        result.put("list",list);
        return objectMapper.writeValueAsString(result);
    }
}
