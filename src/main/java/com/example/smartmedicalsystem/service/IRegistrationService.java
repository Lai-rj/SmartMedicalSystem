package com.example.smartmedicalsystem.service;

import com.example.smartmedicalsystem.entity.Manager;
import com.example.smartmedicalsystem.entity.Registration;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 挂号帖 服务类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
public interface IRegistrationService extends IService<Registration> {
    public boolean updateStatus(Integer id,Integer status);

    public int managerAddRegistration(Registration registration);
    public boolean updateRegistration(Registration registration);
}
