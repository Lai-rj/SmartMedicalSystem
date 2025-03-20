package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.Department;
import com.example.smartmedicalsystem.entity.Doctor;
import com.example.smartmedicalsystem.entity.Manager;
import com.example.smartmedicalsystem.service.IDepartmentService;
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

    @RequestMapping("/managerAddDepartment")
    public String managerAddDepartment(Department department) throws JsonProcessingException {
        Map result=new HashMap();
        int count= departmentService.managerAddDepartment(department);
        if(count>0){
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/manager/updateManager?id=31&postsContent=0&postsImage=0&createTime=2025-03-18%2016:34:56&publisher=6&registrationId=0&publisherType=0
    @RequestMapping("/updateDepartment")
    public String updateDepartment(Department department) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update = departmentService.updateDepartment(department);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/deletePosts?id=31
    @RequestMapping("/deleteDepartment")
    public String deleteDepartment(Integer id) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Department> wrapper=new QueryWrapper();
        wrapper.eq("id",id);
        boolean remove = departmentService.remove(wrapper);
        result.put("flag",remove);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/deleteBatchDepartment")
    public String deleteBatchDepartment(@RequestBody Map<String, List<Integer>> request) throws JsonProcessingException {
        Map result=new HashMap();
        boolean bool=true;
        List<Integer> ids = request.get("ids");
        for(Integer id : ids){
            QueryWrapper<Department> wrapper=new QueryWrapper();
            wrapper.eq("id",id);
            boolean remove = departmentService.remove(wrapper);
            if(!remove){
                bool=false;
            }
        }
        result.put("flag",bool);
        return objectMapper.writeValueAsString(result);
    }
}
