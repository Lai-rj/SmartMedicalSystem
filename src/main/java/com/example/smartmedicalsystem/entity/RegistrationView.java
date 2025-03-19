package com.example.smartmedicalsystem.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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
public class RegistrationView implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
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
    @TableField("registration_time")
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
    @TableField("book_time")
    private String bookTime;

    /**
     * 名称
     */
    @TableField("deptName")
    private String deptname;

    /**
     * 姓名
     */
    @TableField("docName")
    private String docname;

    /**
     * 状态
     */
    @TableField("docStatus")
    private Integer docstatus;

    /**
     * 名称
     */
    @TableField("userName")
    private String username;


}
