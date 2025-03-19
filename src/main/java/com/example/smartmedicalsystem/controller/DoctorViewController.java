package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.Doctor;
import com.example.smartmedicalsystem.entity.DoctorView;
import com.example.smartmedicalsystem.service.IDoctorViewService;
import com.example.smartmedicalsystem.service.impl.DoctorViewServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.lang.Integer.parseInt;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-18
 */
@RestController
@RequestMapping("/doctorView")
public class DoctorViewController {
    @Autowired
    private DoctorViewServiceImpl doctorViewService;
    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result = new HashMap();
        List<DoctorView> list = doctorViewService.list();
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/queryParams")
    public String queryParams(String name,String phone,String hosId,String deptId) throws JsonProcessingException {
        Map result = new HashMap();
        QueryWrapper<DoctorView> wrapper = new QueryWrapper<>();

        if(!Objects.equals(name, "")){
            name="%" + name + "%";
            wrapper.like("name",name);
        }
        if(!Objects.equals(phone, "")){
            wrapper.eq("phone", phone);
        }
        if(!Objects.equals(hosId, "")){
            wrapper.eq("host_id", parseInt(hosId));
        }
        if(!Objects.equals(deptId, "")){
            wrapper.eq("department_id", parseInt(deptId));
        }
        List<DoctorView> list = doctorViewService.list(wrapper);
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }
}
