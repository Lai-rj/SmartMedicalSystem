package com.example.smartmedicalsystem.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class VaccineRecordView implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 疫苗id
     */
    private Integer vaccineId;

    /**
     * 护士id
     */
    private Integer doctorId;

    /**
     * 接种地址
     */
    private String address;

    /**
     * 预约接种时间
     */
    private LocalDateTime appDate;

    /**
     * 实际接种时间
     */
    private LocalDateTime injectedTime;

    /**
     * 接种状态
     */
    private Integer status;

    /**
     * 记录创建时间
     */
    private LocalDateTime createTime;

    /**
     * 疫苗名称
     */
    private String vName;

    /**
     * 名称
     */
    private String username;

    /**
     * 姓名
     */
    @TableField("docName")
    private String docname;


}
