package com.example.smartmedicalsystem.service;

import com.example.smartmedicalsystem.entity.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 医生 服务类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
public interface IDoctorService extends IService<Doctor> {
    public boolean updateStatus(Integer id,Integer status);
}
