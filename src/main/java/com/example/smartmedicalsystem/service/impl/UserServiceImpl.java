package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.User;
import com.example.smartmedicalsystem.mapper.UserMapper;
import com.example.smartmedicalsystem.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 患者用户 服务实现类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
