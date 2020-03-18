package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Employeeec.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value="org-dev-hrm-model-Employeeec")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employeeec implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 员工编号
    */
    @ApiModelProperty(value="员工编号")
    private Integer eid;

    /**
    * 奖罚日期
    */
    @ApiModelProperty(value="奖罚日期")
    private LocalDate ecdate;

    /**
    * 奖罚原因
    */
    @ApiModelProperty(value="奖罚原因")
    private String ecreason;

    /**
    * 奖罚分
    */
    @ApiModelProperty(value="奖罚分")
    private Integer ecpoint;

    /**
    * 奖罚类别，0：奖，1：罚
    */
    @ApiModelProperty(value="奖罚类别，0：奖，1：罚")
    private Integer ectype;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}