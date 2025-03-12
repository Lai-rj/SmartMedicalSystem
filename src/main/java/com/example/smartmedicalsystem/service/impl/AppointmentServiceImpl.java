package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.Appointment;
import com.example.smartmedicalsystem.mapper.AppointmentMapper;
import com.example.smartmedicalsystem.service.IAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预约 服务实现类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements IAppointmentService {

}
