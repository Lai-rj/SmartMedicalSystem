package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.AppointmentVaccine;
import com.example.smartmedicalsystem.entity.Hospital;
import com.example.smartmedicalsystem.entity.Manager;
import com.example.smartmedicalsystem.service.impl.HospitalServiceImpl;
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
        wrapper.like("name",name);
        List<Hospital> hospital=hospitalService.list(wrapper);
        if(hospital!=null){
            result.put("list",hospital);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(Integer id,Integer status) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update= hospitalService.updateStatus(id,status);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/managerAddHospital")
    public String managerAddHospital(Hospital hospital) throws JsonProcessingException {
        // 创建 Date 对象表示当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 创建一个DateTimeFormatter对象，指定日期时间的格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 将LocalDateTime对象格式化为字符串
        String formattedTime = currentTime.format(formatter);
        hospital.setCreateTime(formattedTime);
//        hospital.setCreateDate(currentTime);
        Map result=new HashMap();
        int count= hospitalService.managerAddHospital(hospital);
        if(count>0){
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/manager/updateManager?id=31&postsContent=0&postsImage=0&createTime=2025-03-18%2016:34:56&publisher=6&registrationId=0&publisherType=0
    @RequestMapping("/updateHospital")
    public String updateHospital(Hospital hospital) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update = hospitalService.updateHospital(hospital);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/deletePosts?id=31
    @RequestMapping("/deleteHospital")
    public String deleteHospital(Integer id) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Hospital> wrapper=new QueryWrapper();
        wrapper.eq("id",id);
        boolean remove = hospitalService.remove(wrapper);
        result.put("flag",remove);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/deleteBatchHospital")
    public String deleteBatchHospital(@RequestBody Map<String, List<Integer>> request) throws JsonProcessingException {
        Map result=new HashMap();
        boolean bool=true;
        List<Integer> ids = request.get("ids");
        for(Integer id : ids){
            QueryWrapper<Hospital> wrapper=new QueryWrapper();
            wrapper.eq("id",id);
            boolean remove = hospitalService.remove(wrapper);
            if(!remove){
                bool=false;
            }
        }
        result.put("flag",bool);
        return objectMapper.writeValueAsString(result);
    }
}
