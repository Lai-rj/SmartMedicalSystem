package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.AppointmentVaccine;
import com.example.smartmedicalsystem.entity.Posts;
import com.example.smartmedicalsystem.mapper.AppointmentVaccineMapper;
import com.example.smartmedicalsystem.service.IAppointmentVaccineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 可预约疫苗列表 服务实现类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Service
public class AppointmentVaccineServiceImpl extends ServiceImpl<AppointmentVaccineMapper, AppointmentVaccine> implements IAppointmentVaccineService {
    @Autowired
    private AppointmentVaccineMapper appointmentVaccineMapper;

    @Override
    public int managerAddAppVaccine(AppointmentVaccine appointmentVaccine){
        return appointmentVaccineMapper.managerAddAppVaccine(appointmentVaccine);
    }

    @Override
    public boolean updateAppVaccine(AppointmentVaccine appointmentVaccine){
        return appointmentVaccineMapper.updateAppVaccine(appointmentVaccine);
    }
}
