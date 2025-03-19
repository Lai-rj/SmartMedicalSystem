package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.Vaccine;
import com.example.smartmedicalsystem.mapper.DoctorMapper;
import com.example.smartmedicalsystem.mapper.VaccineMapper;
import com.example.smartmedicalsystem.service.IVaccineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 疫苗 服务实现类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Service
public class VaccineServiceImpl extends ServiceImpl<VaccineMapper, Vaccine> implements IVaccineService {
    @Autowired
    private VaccineMapper vaccineMapper;
    @Override
    public List<Vaccine> queryAll(){
        return vaccineMapper.queryAll();
    }

    @Override
    public List<Vaccine> selectByName(String name){
        return vaccineMapper.selectByName(name);
    }

    @Override
    public boolean updateStatus(Integer id,Integer status){
        return vaccineMapper.updateStatus(id,status);
    }
}
