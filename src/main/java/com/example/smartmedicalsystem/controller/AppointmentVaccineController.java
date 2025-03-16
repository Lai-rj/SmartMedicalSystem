package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.Appointment;
import com.example.smartmedicalsystem.entity.AppointmentVaccine;
import com.example.smartmedicalsystem.entity.User;
import com.example.smartmedicalsystem.entity.VaccineType;
import com.example.smartmedicalsystem.service.impl.AppointmentVaccineServiceImpl;
import com.example.smartmedicalsystem.service.impl.VaccineTypeServiceImpl;
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
 * 可预约疫苗列表 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/appVaccine")
public class AppointmentVaccineController {
    @Autowired
    private AppointmentVaccineServiceImpl appointmentVaccineService;
    ObjectMapper objectMapper=new ObjectMapper();

    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper<AppointmentVaccine> wrapper = new QueryWrapper();
        List<AppointmentVaccine> list= appointmentVaccineService.list(wrapper);
        result.put("list",list);
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/appVaccine/selectByAppVaccineId?vaccine_id=5
    @RequestMapping("/selectByAppVaccineId")
    public String selectById(Integer vaccine_id) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<AppointmentVaccine> wrapper=new QueryWrapper();
        wrapper.eq("vaccine_id",vaccine_id);
        AppointmentVaccine appointmentVaccine=appointmentVaccineService.getOne(wrapper);
        result.put("list",appointmentVaccine);
        return objectMapper.writeValueAsString(result);
    }
}
