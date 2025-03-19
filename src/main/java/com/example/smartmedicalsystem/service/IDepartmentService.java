package com.example.smartmedicalsystem.service;

import com.example.smartmedicalsystem.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 科室 服务类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
public interface IDepartmentService extends IService<Department> {
    public boolean updateStatus(Integer id,Integer status);
}
