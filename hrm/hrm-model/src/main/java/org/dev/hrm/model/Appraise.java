package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Appraise.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 20:15:00
 */
@ApiModel(value="org-dev-hrm-model-Appraise")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appraise implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private Integer eid;

    /**
    * 考评日期
    */
    @ApiModelProperty(value="考评日期")
    private Date appDate;

    /**
    * 考评结果
    */
    @ApiModelProperty(value="考评结果")
    private String appResult;

    /**
    * 考评内容
    */
    @ApiModelProperty(value="考评内容")
    private String appContent;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}