package com.example.smartmedicalsystem.controller;


import com.example.smartmedicalsystem.entity.Appointment;
import com.example.smartmedicalsystem.service.IAppointmentVaccineService;
import com.example.smartmedicalsystem.service.impl.AppointmentServiceImpl;
import com.example.smartmedicalsystem.service.impl.AppointmentVaccineServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 预约 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentServiceImpl appointmentService;

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/add")
    public String add(Appointment appointment) throws JsonProcessingException {
        Map result = new HashMap();
        boolean flag = appointmentService.save(appointment);
        if(flag){
            result.put("flag",true);
        }
        else{
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }
}
