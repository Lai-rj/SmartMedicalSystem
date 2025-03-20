package com.example.smartmedicalsystem.mapper;

import com.example.smartmedicalsystem.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smartmedicalsystem.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 科室 Mapper 接口
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    public boolean updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    int managerAddDepartment(Department department);
    boolean updateDepartment(Department department);

}
