package com.example.smartmedicalsystem.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 疫苗分类
 * </p>
 *
 * @author jerry
 * @since 2025-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VaccineType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 疫苗种类
     */
    private String name;

    /**
     * 疫苗种类描述
     */
    private String remark;

    private Integer status;


}
