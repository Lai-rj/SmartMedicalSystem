package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.Manager;
import com.example.smartmedicalsystem.entity.Posts;
import com.example.smartmedicalsystem.mapper.ManagerMapper;
import com.example.smartmedicalsystem.mapper.PostsMapper;
import com.example.smartmedicalsystem.service.IManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public boolean updateStatus(Integer id,Integer status){
        return managerMapper.updateStatus(id,status);
    }

    @Override
    public int managerAddManager(Manager manager){
        return managerMapper.managerAddManager(manager);
    }

    @Override
    public boolean updateManager(Manager manager){
        return managerMapper.updateManager(manager);
    }
}
