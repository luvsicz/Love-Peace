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
 * @ClassName Appraise.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value="org-dev-hrm-model-Appraise")
@Data
@Builder
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
    private Date appdate;

    /**
    * 考评结果
    */
    @ApiModelProperty(value="考评结果")
    private String appresult;

    /**
    * 考评内容
    */
    @ApiModelProperty(value="考评内容")
    private String appcontent;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}