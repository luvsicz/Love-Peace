package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Department.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value="org-dev-hrm-model-Department")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 部门名称
    */
    @ApiModelProperty(value="部门名称")
    private String name;

    @ApiModelProperty(value="")
    private Integer parentid;

    @ApiModelProperty(value="")
    private String deppath;

    @ApiModelProperty(value="")
    private Boolean enabled;

    @ApiModelProperty(value="")
    private Boolean isparent;

    private static final long serialVersionUID = 1L;
    public Department(String name) {

        this.name = name;
    }
}