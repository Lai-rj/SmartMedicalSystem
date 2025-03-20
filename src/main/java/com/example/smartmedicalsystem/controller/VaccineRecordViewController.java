package com.example.smartmedicalsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smartmedicalsystem.entity.Vaccine;
import com.example.smartmedicalsystem.entity.VaccineRecordView;
import com.example.smartmedicalsystem.service.impl.VaccineRecordViewServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2025-03-18
 */
@RestController
@RequestMapping("/vaccineRecord")
public class VaccineRecordViewController {
    @Autowired
    private VaccineRecordViewServiceImpl vaccineRecordViewService;

    ObjectMapper objectMapper=new ObjectMapper();

    @RequestMapping("/queryAll")
    public String queryAll() throws JsonProcessingException {
        Map result = new HashMap<>();
        List<VaccineRecordView> list= vaccineRecordViewService.list();
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }

    //http://localhost:8088/vaccine/selectByName?name=狂犬疫苗
    @RequestMapping("/selectByDoctorId")
    public String selectByDoctorId(Integer doctorId) throws JsonProcessingException {
        Map result=new HashMap();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("doctor_id",doctorId);
        List<VaccineRecordView> list=vaccineRecordViewService.list(wrapper);
        if(list!=null){
            result.put("list",list);
            result.put("flag",true);
        }else {
            result.put("flag",false);
        }
        return objectMapper.writeValueAsString(result);
    }
}
