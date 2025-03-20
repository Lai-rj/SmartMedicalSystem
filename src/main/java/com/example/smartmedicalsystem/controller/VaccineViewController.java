package com.example.smartmedicalsystem.controller;


import com.example.smartmedicalsystem.entity.Vaccine;
import com.example.smartmedicalsystem.entity.VaccineView;
import com.example.smartmedicalsystem.service.IVaccineViewService;
import com.example.smartmedicalsystem.service.impl.VaccineViewServiceImpl;
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
@RequestMapping("/vaccineView")
public class VaccineViewController {
    @Autowired
    private VaccineViewServiceImpl vaccineViewService;
    ObjectMapper objectMapper = new ObjectMapper();


}
