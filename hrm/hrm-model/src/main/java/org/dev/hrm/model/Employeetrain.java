package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Employeetrain.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 20:15:00
 */
@ApiModel(value="org-dev-hrm-model-Employeetrain")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employeetrain implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 员工编号
    */
    @ApiModelProperty(value="员工编号")
    private Integer eid;

    /**
    * 培训日期
    */
    @ApiModelProperty(value="培训日期")
    private Date trainDate;

    /**
    * 培训内容
    */
    @ApiModelProperty(value="培训内容")
    private String trainContent;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}