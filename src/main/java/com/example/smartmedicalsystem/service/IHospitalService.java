package com.example.smartmedicalsystem.service;

import com.example.smartmedicalsystem.entity.Department;
import com.example.smartmedicalsystem.entity.Hospital;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.smartmedicalsystem.entity.Manager;

/**
 * <p>
 * 医院 服务类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
public interface IHospitalService extends IService<Hospital> {
    public boolean updateStatus(Integer id,Integer status);

    public int managerAddHospital(Hospital hospital);
    public boolean updateHospital(Hospital hospital);
}
