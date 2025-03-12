package com.example.smartmedicalsystem.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 医生
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String image;

    /**
     * 所属医院-编号
     */
    private Integer hostId;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 专业
     */
    private String major;

    /**
     * 手机号码-11位
     */
    private String phone;

    /**
     * 等待接诊-医生、等待接种-护士
     */
    private Integer waitNums;

    /**
     * 科室-编号
     */
    private Integer departmentId;

    /**
     * 角色
     */
    private String role;

    /**
     * 状态
     */
    private Integer status;


}
