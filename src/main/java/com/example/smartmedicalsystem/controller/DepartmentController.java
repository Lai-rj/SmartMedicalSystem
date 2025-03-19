package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.Department;
import com.example.smartmedicalsystem.entity.Doctor;
import com.example.smartmedicalsystem.service.IDepartmentService;
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
 * 科室 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    ObjectMapper objectMapper =new ObjectMapper();

    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result=new HashMap();
        List<Department> list=departmentService.list();
        result.put("list",list);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/queryParams")
    public String queryParams(String name,String status) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        if(!Objects.equals(name, "")){
            name="%"+name+"%";
            wrapper.like("name",name);
        }
        if(!Objects.equals(status, "")){
            wrapper.eq("status",parseInt(status));
        }
        List<Department> list=departmentService.list(wrapper);
        result.put("list",list);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(Integer id,Integer status) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update= departmentService.updateStatus(id,status);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/selectByDeptName")
    public String selectByDeptName(String name) throws JsonProcessingException {
        Map result = new HashMap();
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        Department department = departmentService.getOne(wrapper);
        result.put("dept",department);
        return objectMapper.writeValueAsString(result);
    }
}
