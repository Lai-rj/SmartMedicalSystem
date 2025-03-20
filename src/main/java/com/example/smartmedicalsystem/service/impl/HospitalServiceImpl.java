package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.Department;
import com.example.smartmedicalsystem.entity.Hospital;
import com.example.smartmedicalsystem.entity.Manager;
import com.example.smartmedicalsystem.mapper.DoctorMapper;
import com.example.smartmedicalsystem.mapper.HospitalMapper;
import com.example.smartmedicalsystem.service.IHospitalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.coyote.http2.HpackDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 医院 服务实现类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Service
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements IHospitalService {
    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    public boolean updateStatus(Integer id,Integer status){
        return hospitalMapper.updateStatus(id,status);
    }

    @Override
    public int managerAddHospital(Hospital hospital){
        return hospitalMapper.managerAddHospital(hospital);
    }

    @Override
    public boolean updateHospital(Hospital hospital){
        return hospitalMapper.updateHospital(hospital);
    }
}
