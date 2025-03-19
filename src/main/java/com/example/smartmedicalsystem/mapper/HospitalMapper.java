package com.example.smartmedicalsystem.mapper;

import com.example.smartmedicalsystem.entity.Hospital;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 医院 Mapper 接口
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Mapper
public interface HospitalMapper extends BaseMapper<Hospital> {
    public boolean updateStatus(@Param("id") Integer id, @Param("status") Integer status);
}
