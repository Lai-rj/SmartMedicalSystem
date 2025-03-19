package com.example.smartmedicalsystem.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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
    @TableId(type = IdType.AUTO)
    private Integer id;//不加get不到id

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime produceTime;

    private Integer status;


}
