package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.Posts;
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
 * 疫苗 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/vaccine")
public class VaccineController {
    @Autowired
    private VaccineServiceImpl vaccineService;
    ObjectMapper objectMapper=new ObjectMapper();

    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result = new HashMap<>();
        List<Vaccine> list= vaccineService.queryAll();
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/vaccine/selectByName?name=狂犬疫苗
    @RequestMapping("/selectByName")
    public String selectByName(String name) throws JsonProcessingException {
        Map result=new HashMap();
        List<Vaccine> vaccine=vaccineService.selectByName(name);
        if(vaccine!=null){
            result.put("list",vaccine);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(Integer id,Integer status) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update= vaccineService.updateStatus(id,status);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/managerAddVaccine")
    public String managerAddVaccine(Vaccine vaccine) throws JsonProcessingException {
        // 创建 Date 对象表示当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        vaccine.setProduceTime(currentTime);
        Map result=new HashMap();
        int count= vaccineService.managerAddVaccine(vaccine);
        if(count>0){
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/updatePosts?id=31&postsContent=0&postsImage=0&createTime=2025-03-18%2016:34:56&publisher=6&registrationId=0&publisherType=0
    @RequestMapping("/updateVaccine")
    public String updateVaccine(Vaccine vaccine) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update = vaccineService.updateVaccine(vaccine);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/deletePosts?id=31
    @RequestMapping("/deleteVaccine")
    public String deleteVaccine(Integer id) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Vaccine> wrapper=new QueryWrapper();
        wrapper.eq("id",id);
        boolean remove = vaccineService.remove(wrapper);
        result.put("flag",remove);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/deleteBatchVaccine")
    public String deleteBatchVaccine(@RequestBody Map<String, List<Integer>> request) throws JsonProcessingException {
        Map result=new HashMap();
        boolean bool=true;
        List<Integer> ids = request.get("ids");
        for(Integer id : ids){
            QueryWrapper<Vaccine> wrapper=new QueryWrapper();
            wrapper.eq("id",id);
            boolean remove = vaccineService.remove(wrapper);
            if(!remove){
                bool=false;
            }
        }
        result.put("flag",bool);
        return objectMapper.writeValueAsString(result);
    }
}
