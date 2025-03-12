package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.Manager;
import com.example.smartmedicalsystem.mapper.ManagerMapper;
import com.example.smartmedicalsystem.service.IManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
