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
 * 挂号帖
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;//不加get不到id

    /**
     * 挂号科室
     */
    private Integer diseaseType;

    /**
     * 病情描述
     */
    private String description;

    /**
     * 病情描述的图片
     */
    private String describeImg;

    /**
     * 挂号时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String registrationTime;

    /**
     * 医生编号
     */
    private Integer doctorId;

    /**
     * 用户-编号
     */
    private Integer userId;

    /**
     * 挂号帖-状态-0待接诊-1已接诊-2完成
     */
    private Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String bookTime;


}
