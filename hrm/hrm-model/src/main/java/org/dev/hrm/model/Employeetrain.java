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
 * @ClassName Employeetrain.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value="org-dev-hrm-model-Employeetrain")
@Data
@Builder
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
    private LocalDate traindate;

    /**
    * 培训内容
    */
    @ApiModelProperty(value="培训内容")
    private String traincontent;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}