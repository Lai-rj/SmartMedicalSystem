package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.Doctor;
import com.example.smartmedicalsystem.mapper.DoctorMapper;
import com.example.smartmedicalsystem.service.IDoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 医生 服务实现类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {

}
