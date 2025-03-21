package com.example.smartmedicalsystem.service;

import com.example.smartmedicalsystem.entity.Manager;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.smartmedicalsystem.entity.Posts;

/**
 * <p>
 * 管理员 服务类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
public interface IManagerService extends IService<Manager> {
    public boolean updateStatus(Integer id,Integer status);

    public int managerAddManager(Manager manager);
    public boolean updateManager(Manager manager);
}
