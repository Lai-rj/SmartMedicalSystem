package com.example.smartmedicalsystem.mapper;

import com.example.smartmedicalsystem.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 患者用户 Mapper 接口
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
