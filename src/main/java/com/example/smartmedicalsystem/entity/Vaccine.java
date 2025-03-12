package com.example.smartmedicalsystem.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 疫苗
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Vaccine implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 疫苗名称
     */
    private String name;

    /**
     * 疫苗种类
     */
    private Integer typeId;

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

    /**
     * 生产时间
     */
    private LocalDateTime produceTime;

    private Integer status;


}
