package com.example.smartmedicalsystem.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 可预约疫苗列表
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentVaccine implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;//不加get不到id

    /**
     * 疫苗id
     */
    private Integer vaccineId;

    /**
     * 可接种数量
     */
    private Integer nums;

    /**
     * 已预约数量
     */
    private Integer appedNums;

    /**
     * 接种地址
     */
    private String address;

    /**
     * 预约接种时间
     */
    private LocalDateTime appDate;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
