package com.example.smartmedicalsystem.service.impl;

import com.example.smartmedicalsystem.entity.Department;
import com.example.smartmedicalsystem.entity.Manager;
import com.example.smartmedicalsystem.mapper.DepartmentMapper;
import com.example.smartmedicalsystem.mapper.DoctorMapper;
import com.example.smartmedicalsystem.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 科室 服务实现类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public boolean updateStatus(Integer id,Integer status){
        return departmentMapper.updateStatus(id,status);
    }

    @Override
    public int managerAddDepartment(Department department){
        return departmentMapper.managerAddDepartment(department);
    }

    @Override
    public boolean updateDepartment(Department department){
        return departmentMapper.updateDepartment(department);
    }
}
