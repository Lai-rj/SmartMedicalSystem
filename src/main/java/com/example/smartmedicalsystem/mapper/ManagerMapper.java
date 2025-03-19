package com.example.smartmedicalsystem.mapper;

import com.example.smartmedicalsystem.entity.Manager;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smartmedicalsystem.entity.Posts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 管理员 Mapper 接口
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Mapper
public interface ManagerMapper extends BaseMapper<Manager> {
    public boolean updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    int managerAddManager(Manager manager);
    boolean updateManager(Manager manager);
}
