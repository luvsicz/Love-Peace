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
 * @ClassName Oplog.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value="org-dev-hrm-model-Oplog")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Oplog implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 添加日期
    */
    @ApiModelProperty(value="添加日期")
    private Date adddate;

    /**
    * 操作内容
    */
    @ApiModelProperty(value="操作内容")
    private String operate;

    /**
    * 操作员ID
    */
    @ApiModelProperty(value="操作员ID")
    private Integer hrid;

    private static final long serialVersionUID = 1L;
}