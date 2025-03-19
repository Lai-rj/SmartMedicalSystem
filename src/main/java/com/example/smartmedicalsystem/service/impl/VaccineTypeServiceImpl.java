package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.Posts;
import com.example.smartmedicalsystem.entity.Vaccine;
import com.example.smartmedicalsystem.entity.VaccineType;
import com.example.smartmedicalsystem.mapper.DoctorMapper;
import com.example.smartmedicalsystem.mapper.VaccineTypeMapper;
import com.example.smartmedicalsystem.service.IVaccineTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 疫苗分类 服务实现类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Service
public class VaccineTypeServiceImpl extends ServiceImpl<VaccineTypeMapper, VaccineType> implements IVaccineTypeService {
    @Autowired
    private VaccineTypeMapper vaccineTypeMapper;

    @Override
    public int managerAddVaccineType(VaccineType vaccineType){
        return vaccineTypeMapper.managerAddVaccineType(vaccineType);
    }

    @Override
    public boolean updateVaccineType(VaccineType vaccineType){
        return vaccineTypeMapper.updateVaccineType(vaccineType);
    }

    @Override
    public boolean updateStatus(Integer id,Integer status){
        return vaccineTypeMapper.updateStatus(id,status);
    }
}
