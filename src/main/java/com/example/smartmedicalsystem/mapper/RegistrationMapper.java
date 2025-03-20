package com.example.smartmedicalsystem.mapper;

import com.example.smartmedicalsystem.entity.Manager;
import com.example.smartmedicalsystem.entity.Registration;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 挂号帖 Mapper 接口
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Mapper
public interface RegistrationMapper extends BaseMapper<Registration> {
    public boolean updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    int managerAddRegistration(Registration registration);
    boolean updateRegistration(Registration registration);
}
