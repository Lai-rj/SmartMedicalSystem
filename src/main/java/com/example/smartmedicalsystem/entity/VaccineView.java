package com.example.smartmedicalsystem.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author jerry
 * @since 2025-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VaccineView implements Serializable {

    private static final long serialVersionUID = 1L;

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

    /**
     * 疫苗名称
     */
    private String vaccineName;

    /**
     * 作用
     */
    private String function;

    /**
     * 目标人群
     */
    private String target;

    /**
     * 不良反应
     */
    private String adverseReaction;

    /**
     * 生产厂家
     */
    private String producer;

    private Integer status;

    /**
     * 生产时间
     */
    private LocalDateTime produceTime;

    /**
     * 疫苗种类
     */
    private Integer typeId;

    /**
     * 疫苗种类
     */
    private String typeName;

    /**
     * 疫苗种类描述
     */
    private String remark;


}
