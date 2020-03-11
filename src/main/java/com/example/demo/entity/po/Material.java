package com.example.demo.entity.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 2020/3/8
 *
 * @author Ch-shuai
 * @Description
 */
@Data
public class Material {
    private Long id;

    private String name;

    private String description;

    private Integer type;

    private Long creatorId;

    private String creator;

    private Date createTime;

    private Date updateTime;

}
