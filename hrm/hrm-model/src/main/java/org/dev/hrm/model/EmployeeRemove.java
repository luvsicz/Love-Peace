package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName EmployeeRemove.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 20:16:00
 */
@ApiModel(value="org-dev-hrm-model-EmployeeRemove")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRemove implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private Integer eid;

    /**
    * 调动后部门
    */
    @ApiModelProperty(value="调动后部门")
    private Integer afterDepId;

    /**
    * 调动后职位
    */
    @ApiModelProperty(value="调动后职位")
    private Integer afterJobId;

    /**
    * 调动日期
    */
    @ApiModelProperty(value="调动日期")
    private Date removeDate;

    /**
    * 调动原因
    */
    @ApiModelProperty(value="调动原因")
    private String reason;

    @ApiModelProperty(value="")
    private String remark;

    private static final long serialVersionUID = 1L;
}