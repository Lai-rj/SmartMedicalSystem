package com.example.smartmedicalsystem.controller;


import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.smartmedicalsystem.entity.Doctor;
import com.example.smartmedicalsystem.entity.Manager;
import com.example.smartmedicalsystem.entity.User;
import com.example.smartmedicalsystem.entity.VaccineType;
import com.example.smartmedicalsystem.service.IDepartmentService;
import com.example.smartmedicalsystem.service.QRService;
import com.example.smartmedicalsystem.service.impl.DoctorServiceImpl;
import com.example.smartmedicalsystem.service.impl.VaccineServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.lang.Integer.parseInt;

/**
 * <p>
 * 医生 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorServiceImpl doctorService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private QRService qrService;

    //注入配置依赖
    @Resource
    QrConfig config;

    @RequestMapping("/queryAll")
    public String queryAll(String name,String phone,String hosId,String deptId) throws JsonProcessingException {
        Map result = new HashMap();
        QueryWrapper<Doctor> wrapper = new QueryWrapper<>();

        if(!Objects.equals(name, "")){
            name="%" + name + "%";
            wrapper.like("name",name);
        }
        else if(!Objects.equals(phone, "")){
            wrapper.eq("phone", phone);
        }
        else if(!Objects.equals(hosId, "")){
            wrapper.eq("host_id", parseInt(hosId));
        }
        else if(!Objects.equals(deptId, "")){
            wrapper.eq("department_id", parseInt(deptId));
        }
        List<Doctor> list = doctorService.list(wrapper);
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/loginDoctor")
    public String login(String phone, String password) throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("phone", phone);
        wrapper.eq("password", password);
        Doctor doctor = doctorService.getOne(wrapper);
        if (doctor != null) {
            result.put("flag", true);
            result.put("role", "doctor");
            result.put("user", "doctor");
        } else {
            result.put("flag", false);
            result.put("message", "登录失败");
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/selectById")
    public String selectById(Integer id) throws JsonProcessingException {
        Map result = new HashMap();
        QueryWrapper<Doctor> wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        Doctor doctor = doctorService.getOne(wrapper);
        result.put("doctor", doctor);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/selectByDeptId")
    public String selectByDeptId(int deptId) throws JsonProcessingException {
        Map result = new HashMap();
        QueryWrapper<Doctor> wrapper = new QueryWrapper();
        wrapper.eq("department_id", deptId);
        List<Doctor> doctorList = doctorService.list(wrapper);
        result.put("list", doctorList);
        result.put("user", "doctor");
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/add")
    public String addDoctor(Doctor newDoctor) throws JsonProcessingException {
        Map result = new HashMap();
        boolean flag = doctorService.save(newDoctor);
        if(flag){
            result.put("message","success");
        }
        else{
            result.put("message","fail");
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/update")
    public String updateDoctor(Doctor doctor) throws JsonProcessingException {
        Map result = new HashMap();
        UpdateWrapper<Doctor> wrapper = new UpdateWrapper<>();
        wrapper.eq("doctor", doctor);
        boolean flag = doctorService.update(wrapper);
        if(flag){
            result.put("message","success");
        }
        else{
            result.put("message","fail");
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(Integer id,int status) throws JsonProcessingException {
        Map result = new HashMap();
        UpdateWrapper<Doctor> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",id);
        wrapper.eq("status",status);
        boolean flag = doctorService.update(wrapper);
        if(flag){
            result.put("message","success");
        }
        else{
            result.put("message","fail");
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/delete")
    public String batchDelete(Integer id) throws JsonProcessingException {
        Map result = new HashMap();
        boolean flag = doctorService.removeById(id);
        if(flag){
            result.put("message","success");
        }
        else{
            result.put("message","fail");
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/batchDelete")
    public String batchDelete(List<Integer> ids) throws JsonProcessingException {
        Map<String, Object> result = new HashMap<>();

        // 批量删除医生记录
        boolean flag = doctorService.removeByIds(ids); // 假设 doctorService 有这个方法
        if (flag) {
            result.put("message", "success");
        } else {
            result.put("message", "fail");
        }

        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/code")
    public void generateUserCode(Long doctorid, HttpServletResponse response) throws IOException {
        QueryWrapper<Doctor> wrapper=new QueryWrapper();
        wrapper.eq("id",doctorid);
        Doctor doctor=this.doctorService.getOne(wrapper);
        if(doctor.getStatus()==1){
            config.setBackColor(Color.green.getRGB());
        }else if(doctor.getStatus() ==2){
            config.setBackColor(Color.yellow.getRGB());
        }else{
            config.setBackColor(Color.red.getRGB());
        }

        QrCodeUtil.generate(objectMapper.writeValueAsString(doctor),config,"png",response.getOutputStream());
    }
}
