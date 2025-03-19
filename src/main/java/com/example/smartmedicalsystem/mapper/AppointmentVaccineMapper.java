package com.example.smartmedicalsystem.mapper;

import com.example.smartmedicalsystem.entity.AppointmentVaccine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smartmedicalsystem.entity.Posts;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 可预约疫苗列表 Mapper 接口
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Mapper
public interface AppointmentVaccineMapper extends BaseMapper<AppointmentVaccine> {
    int managerAddAppVaccine(AppointmentVaccine appointmentVaccine);
    boolean updateAppVaccine (AppointmentVaccine appointmentVaccine);
}
