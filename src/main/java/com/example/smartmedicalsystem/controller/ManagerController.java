package com.example.smartmedicalsystem.controller;


import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.*;
import com.example.smartmedicalsystem.service.IManagerService;
import com.example.smartmedicalsystem.service.QRService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.ErrorState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.Namespace;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private IManagerService managerService;

    @Autowired
    private QRService qrService;

    @Resource
    QrConfig config;

    ObjectMapper objectMapper =new ObjectMapper();
    @RequestMapping("/loginManager")
    public String login(String name,String password) throws JsonProcessingException {
        Map result = new HashMap<>();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",name);
        wrapper.eq("password",password);
        Manager manager = managerService.getOne(wrapper);
        if(manager!=null){
            result.put("flag",true);
            result.put("role","manager");
            result.put("user",manager);
        }else{
            result.put("flag",false);
            result.put("message","登录失败");
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/selectById")
    public String selectById(Integer id) throws JsonProcessingException {
        Map result = new HashMap();
        QueryWrapper<Manager> wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        Manager manager = managerService.getOne(wrapper);
        result.put("manager",manager);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/code")
    public void generateUserCode(Long managerid, HttpServletResponse response) throws IOException {
        QueryWrapper<Manager> wrapper=new QueryWrapper();
        wrapper.eq("id",managerid);
        Manager manager=this.managerService.getOne(wrapper);
        if(manager.getStatus()==1){
            config.setBackColor(Color.green.getRGB());
        }else if(manager.getStatus() ==2){
            config.setBackColor(Color.yellow.getRGB());
        }else{
            config.setBackColor(Color.red.getRGB());
        }

        QrCodeUtil.generate(objectMapper.writeValueAsString(manager),config,"png",response.getOutputStream());
    }

    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result = new HashMap();
        List<Manager> list = managerService.list();
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/selectByName")
    public String selectByName(String name) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Manager> wrapper=new QueryWrapper();
        wrapper.like("name",name);
        List<Manager> managers= managerService.list(wrapper);
        if(managers!=null){
            result.put("list",managers);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(Integer id,Integer status) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update= managerService.updateStatus(id,status);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/managerAddManager")
    public String managerAddManager(Manager manager) throws JsonProcessingException {
        // 创建 Date 对象表示当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        manager.setCreateDate(currentTime);
        Map result=new HashMap();
        int count= managerService.managerAddManager(manager);
        if(count>0){
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/manager/updateManager?id=31&postsContent=0&postsImage=0&createTime=2025-03-18%2016:34:56&publisher=6&registrationId=0&publisherType=0
    @RequestMapping("/updateManager")
    public String updateManager(Manager manager) throws JsonProcessingException {
        Map result=new HashMap();
        boolean update = managerService.updateManager(manager);
        result.put("flag",update);
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/posts/deletePosts?id=31
    @RequestMapping("/deleteManager")
    public String deleteManager(Integer id) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper<Manager> wrapper=new QueryWrapper();
        wrapper.eq("id",id);
        boolean remove = managerService.remove(wrapper);
        result.put("flag",remove);
        return objectMapper.writeValueAsString(result);
    }

    @RequestMapping("/deleteBatchManager")
    public String deleteBatchManager(@RequestBody Map<String, List<Integer>> request) throws JsonProcessingException {
        Map result=new HashMap();
        boolean bool=true;
        List<Integer> ids = request.get("ids");
        for(Integer id : ids){
            QueryWrapper<Manager> wrapper=new QueryWrapper();
            wrapper.eq("id",id);
            boolean remove = managerService.remove(wrapper);
            if(!remove){
                bool=false;
            }
        }
        result.put("flag",bool);
        return objectMapper.writeValueAsString(result);
    }
}
