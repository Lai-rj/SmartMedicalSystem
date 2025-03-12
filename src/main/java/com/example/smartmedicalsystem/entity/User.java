package com.example.smartmedicalsystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 患者用户
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String image;

    /**
     * 身份证-18位
     */
    @TableField("codeId")
    private String codeid;

    /**
     * 手机号码-11位
     */
    private String phone;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 通行二维码-1绿码-2黄码-3红码
     */
    private Integer qrcode;

    /**
     * 状态
     */
    private Integer status;


}
