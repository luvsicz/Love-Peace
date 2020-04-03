package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Adjustsalary.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 20:14:00
 */
@ApiModel(value="org-dev-hrm-model-Adjustsalary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adjustsalary implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private Integer eid;

    /**
    * 调薪日期
    */
    @ApiModelProperty(value="调薪日期")
    private LocalDate asDate;

    /**
    * 调前薪资
    */
    @ApiModelProperty(value="调前薪资")
    private Integer beforeSalary;

    /**
    * 调后薪资
    */
    @ApiModelProperty(value="调后薪资")
    private Integer afterSalary;

    /**
    * 调薪原因
    */
    @ApiModelProperty(value="调薪原因")
    private String reason;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}