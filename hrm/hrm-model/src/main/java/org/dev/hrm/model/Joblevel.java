package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Joblevel.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value="org-dev-hrm-model-Joblevel")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Joblevel implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 职称名称
    */
    @ApiModelProperty(value="职称名称")
    private String name;

    @ApiModelProperty(value="")
    private String titlelevel;

    @ApiModelProperty(value="")
    private LocalDateTime createdate;

    @ApiModelProperty(value="")
    private Boolean enabled;

    private static final long serialVersionUID = 1L;
}