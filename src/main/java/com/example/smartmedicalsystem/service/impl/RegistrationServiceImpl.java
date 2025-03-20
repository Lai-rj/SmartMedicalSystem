package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.Manager;
import com.example.smartmedicalsystem.entity.Registration;
import com.example.smartmedicalsystem.mapper.ManagerMapper;
import com.example.smartmedicalsystem.mapper.RegistrationMapper;
import com.example.smartmedicalsystem.service.IRegistrationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 挂号帖 服务实现类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements IRegistrationService {
    @Autowired
    private RegistrationMapper registrationMapper;

    @Override
    public boolean updateStatus(Integer id,Integer status){
        return registrationMapper.updateStatus(id,status);
    }

    @Override
    public int managerAddRegistration(Registration registration){
        return registrationMapper.managerAddRegistration(registration);
    }

    @Override
    public boolean updateRegistration(Registration registration){
        return registrationMapper.updateRegistration(registration);
    }
}
