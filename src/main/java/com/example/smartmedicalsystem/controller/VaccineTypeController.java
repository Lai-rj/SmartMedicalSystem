package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.Posts;
import com.example.smartmedicalsystem.entity.User;
import com.example.smartmedicalsystem.entity.Vaccine;
import com.example.smartmedicalsystem.entity.VaccineType;
import com.example.smartmedicalsystem.service.impl.VaccineServiceImpl;
import com.example.smartmedicalsystem.service.impl.VaccineTypeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 疫苗分类 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/vaccineType")
public class VaccineTypeController {
    @Autowired
    private VaccineTypeServiceImpl vaccineTypeService;
    ObjectMapper objectMapper=new ObjectMapper();

    @RequestMapping("/queryAll")
    public String queryAll(String vaccineName) throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper<VaccineType> wrapper = new QueryWrapper();
        List<VaccineType> list= vaccineTypeService.list(wrapper);
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/vaccineType/selectByName?name=灭活疫苗
    @RequestMapping("/selectByName")
    public String selectByName(String name) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<VaccineType> wrapper=new QueryWrapper();
        wrapper.like("name",name);
        List<VaccineType> vaccineType=vaccineTypeService.list(wrapper);
        if(vaccineType!=null){
            result.put("list",vaccineType);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(Integer id,Integer status) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update= vaccineTypeService.updateStatus(id,status);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/managerAddVaccineType")
    public String managerAddVaccineType(VaccineType vaccineType) throws JsonProcessingException {
        Map result=new HashMap();
        int count= vaccineTypeService.managerAddVaccineType(vaccineType);
        if(count>0){
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/updatePosts?id=31&postsContent=0&postsImage=0&createTime=2025-03-18%2016:34:56&publisher=6&registrationId=0&publisherType=0
    @RequestMapping("/updateVaccineType")
    public String updateVaccineType(VaccineType vaccineType) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update = vaccineTypeService.updateVaccineType(vaccineType);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/deletePosts?id=31
    @RequestMapping("/deleteVaccineType")
    public String deleteVaccineType(Integer id) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<VaccineType> wrapper=new QueryWrapper();
        wrapper.eq("id",id);
        boolean remove = vaccineTypeService.remove(wrapper);
        result.put("flag",remove);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/deleteBatchVaccineType")
    public String deleteBatchVaccineType(@RequestBody Map<String, List<Integer>> request) throws JsonProcessingException {
        Map result=new HashMap();
        boolean bool=true;
        List<Integer> ids = request.get("ids");
        for(Integer id : ids){
            QueryWrapper<VaccineType> wrapper=new QueryWrapper();
            wrapper.eq("id",id);
            boolean remove = vaccineTypeService.remove(wrapper);
            if(!remove){
                bool=false;
            }
        }
        result.put("flag",bool);
        return objectMapper.writeValueAsString(result);
    }

}
