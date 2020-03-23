package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Employeeremove.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value="org-dev-hrm-model-Employeeremove")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employeeremove implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private Integer eid;

    /**
    * 调动后部门
    */
    @ApiModelProperty(value="调动后部门")
    private Integer afterdepid;

    /**
    * 调动后职位
    */
    @ApiModelProperty(value="调动后职位")
    private Integer afterjobid;

    /**
    * 调动日期
    */
    @ApiModelProperty(value="调动日期")
    private Date removedate;

    /**
    * 调动原因
    */
    @ApiModelProperty(value="调动原因")
    private String reason;

    @ApiModelProperty(value="")
    private String remark;

    private static final long serialVersionUID = 1L;
}