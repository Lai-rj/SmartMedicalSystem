package com.example.smartmedicalsystem.mapper;

import com.example.smartmedicalsystem.entity.Vaccine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 疫苗 Mapper 接口
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Mapper
public interface VaccineMapper extends BaseMapper<Vaccine> {
    List<Vaccine> queryAll();
    List<Vaccine> selectByName(String name);
    public boolean updateStatus(@Param("id") Integer id, @Param("status") Integer status);
}
