package com.example.smartmedicalsystem.service;

import com.example.smartmedicalsystem.entity.Vaccine;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.smartmedicalsystem.mapper.VaccineMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.PrivateKey;
import java.util.List;

/**
 * <p>
 * 疫苗 服务类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
public interface IVaccineService extends IService<Vaccine> {
    List<Vaccine> queryAll();
    List<Vaccine> selectByName(String name);
    public boolean updateStatus(Integer id,Integer status);
}
