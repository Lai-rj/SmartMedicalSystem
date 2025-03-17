package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.AppointmentVaccine;
import com.example.smartmedicalsystem.entity.Hospital;
import com.example.smartmedicalsystem.service.impl.HospitalServiceImpl;
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
 * 医院 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalServiceImpl hospitalService;
    ObjectMapper objectMapper=new ObjectMapper();
    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper<Hospital> wrapper = new QueryWrapper();
        List<Hospital> list= hospitalService.list(wrapper);
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/hospital/selectByHospitalName?name=北京大学第一医院
    @RequestMapping("/selectByHospitalName")
    public String selectByName(String name) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Hospital> wrapper=new QueryWrapper();
        wrapper.eq("name",name);
        Hospital hospital=hospitalService.getOne(wrapper);
        if(hospital!=null){
            result.put("list",hospital);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }
}
