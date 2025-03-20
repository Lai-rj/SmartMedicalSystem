package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.AppointmentVaccine;
import com.example.smartmedicalsystem.entity.Doctor;
import com.example.smartmedicalsystem.entity.Posts;
import com.example.smartmedicalsystem.entity.Registration;
import com.example.smartmedicalsystem.mapper.RegistrationMapper;
import com.example.smartmedicalsystem.service.IRegistrationService;
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
        registration.setRegistrationTime(regisTime);
        registration.setBookTime(bookTime);
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        registration.setRegistrationTime(LocalDateTime.parse(regisTime,formatter));
        registration.setBookTime(LocalDateTime.parse(bookTime,formatter));*/
        boolean flag = registrationService.save(registration);
        result.put("flag", true);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper<Registration> wrapper = new QueryWrapper();
        List<Registration> list= registrationService.list(wrapper);
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }


    //http://localhost:8088/posts/selectByPublisherId?publisher=23
    @RequestMapping("/selectByDoctorId")
    public String selectByDoctorId(Integer doctorId) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Registration> wrapper=new QueryWrapper();
        wrapper.eq("doctor_id",doctorId);
        List<Registration> list=registrationService.list(wrapper);
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/selectByRegistrationId?publisher=3&registrationId=22
    @RequestMapping("/selectByUserId")
    public String selectByPublisherId(Integer doctorId,Integer userId) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Registration> wrapper=new QueryWrapper();
        wrapper.eq("doctor_id",doctorId);
        wrapper.eq("user_id",userId);
        List<Registration> list=registrationService.list(wrapper);
        if(list!=null && !list.isEmpty()){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/managerAddRegistration")
    public String managerAddRegistration(Registration registration) throws JsonProcessingException {
        Map result=new HashMap();
        System.out.println(registration.toString());
        int count= registrationService.managerAddRegistration(registration);
        if(count>0){
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/updatePosts?id=31&postsContent=0&postsImage=0&createTime=2025-03-18%2016:34:56&publisher=6&registrationId=0&publisherType=0
    @RequestMapping("/updateRegistration")
    public String updateRegistration(Registration registration) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update = registrationService.updateRegistration(registration);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/deletePosts?id=31
    @RequestMapping("/deleteRegistration")
    public String deleteRegistration(Integer id) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Registration> wrapper=new QueryWrapper();
        wrapper.eq("id",id);
        boolean remove = registrationService.remove(wrapper);
        result.put("flag",remove);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/deleteBatchRegistration")
    public String deleteBatchRegistration(@RequestBody Map<String, List<Integer>> request) throws JsonProcessingException {
        Map result=new HashMap();
        boolean bool=true;
        List<Integer> ids = request.get("ids");
        for(Integer id : ids){
            QueryWrapper<Registration> wrapper=new QueryWrapper();
            wrapper.eq("id",id);
            boolean remove = registrationService.remove(wrapper);
            if(!remove){
                bool=false;
            }
        }
        result.put("flag",bool);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(Integer id,Integer status) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update= registrationService.updateStatus(id,status);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }


}
