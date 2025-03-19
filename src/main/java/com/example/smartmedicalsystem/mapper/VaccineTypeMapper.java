package com.example.smartmedicalsystem.mapper;

import com.example.smartmedicalsystem.entity.Posts;
import com.example.smartmedicalsystem.entity.Vaccine;
import com.example.smartmedicalsystem.entity.VaccineType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 疫苗分类 Mapper 接口
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Mapper
public interface VaccineTypeMapper extends BaseMapper<VaccineType> {
    public boolean updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    int managerAddVaccineType(VaccineType vaccineType);
    boolean updateVaccineType(VaccineType vaccineType);
}
