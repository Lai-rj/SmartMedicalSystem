package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.*;
import com.example.smartmedicalsystem.mapper.AppointmentVaccineMapper;
import com.example.smartmedicalsystem.service.impl.AppointmentVaccineServiceImpl;
import com.example.smartmedicalsystem.service.impl.VaccineTypeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/appVaccine/selectByAppVaccineId?vaccine_id=5
    @RequestMapping("/selectByAppVaccineId")
    public String selectById(Integer vaccine_id) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<AppointmentVaccine> wrapper=new QueryWrapper();
        wrapper.eq("vaccine_id",vaccine_id);
        AppointmentVaccine appointmentVaccine=appointmentVaccineService.getOne(wrapper);
        if(appointmentVaccine!=null){
            result.put("list",appointmentVaccine);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/managerAddAppVaccine")
    public String managerAddAppVaccine(AppointmentVaccine appointmentVaccine) throws JsonProcessingException {
        // 创建 Date 对象表示当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 创建一个DateTimeFormatter对象，指定日期时间的格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 将LocalDateTime对象格式化为字符串
        String formattedTime = currentTime.format(formatter);
        appointmentVaccine.setCreateTime(formattedTime);
//        appointmentVaccine.setAppDate(currentTime);
        appointmentVaccine.setAppDate(appointmentVaccine.getAppDate());
        Map result=new HashMap();
        int count= appointmentVaccineService.managerAddAppVaccine(appointmentVaccine);
        if(count>0){
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/updatePosts?id=31&postsContent=0&postsImage=0&createTime=2025-03-18%2016:34:56&publisher=6&registrationId=0&publisherType=0
    @RequestMapping("/updateAppVaccine")
    public String updateAppVaccine(AppointmentVaccine appointmentVaccine) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update = appointmentVaccineService.updateAppVaccine(appointmentVaccine);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/deletePosts?id=31
    @RequestMapping("/deleteAppVaccine")
    public String deleteAppVaccine(Integer id) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<AppointmentVaccine> wrapper=new QueryWrapper();
        wrapper.eq("id",id);
        boolean remove = appointmentVaccineService.remove(wrapper);
        result.put("flag",remove);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/deleteBatchAppVaccine")
    public String deleteBatchAppVaccine(@RequestBody Map<String, List<Integer>> request) throws JsonProcessingException {
        Map result=new HashMap();
        boolean bool=true;
        List<Integer> ids = request.get("ids");
        for(Integer id : ids){
            QueryWrapper<AppointmentVaccine> wrapper=new QueryWrapper();
            wrapper.eq("id",id);
            boolean remove = appointmentVaccineService.remove(wrapper);
            if(!remove){
                bool=false;
            }
        }
        result.put("flag",bool);
        return objectMapper.writeValueAsString(result);
    }
}
