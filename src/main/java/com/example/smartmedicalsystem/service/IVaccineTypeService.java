package com.example.smartmedicalsystem.service;

import com.example.smartmedicalsystem.entity.Posts;
import com.example.smartmedicalsystem.entity.VaccineType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 疫苗分类 服务类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
public interface IVaccineTypeService extends IService<VaccineType> {
    public boolean updateStatus(Integer id,Integer status);

    public int managerAddVaccineType(VaccineType vaccineType);
    public boolean updateVaccineType(VaccineType vaccineType);
}
