package com.example.smartmedicalsystem.service;

import com.example.smartmedicalsystem.entity.AppointmentVaccine;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.smartmedicalsystem.entity.Posts;

/**
 * <p>
 * 可预约疫苗列表 服务类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
public interface IAppointmentVaccineService extends IService<AppointmentVaccine> {
    public int managerAddAppVaccine(AppointmentVaccine appointmentVaccine);
    public boolean updateAppVaccine(AppointmentVaccine appointmentVaccine);
}
