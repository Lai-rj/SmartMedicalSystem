package com.example.smartmedicalsystem.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账号-3个字母+4个数字
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
     * 创建时间
     */
    private LocalDateTime createDate;

    private Integer status;


}
