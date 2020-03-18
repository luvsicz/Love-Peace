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
 * @ClassName Position.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value="org-dev-hrm-model-Position")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Position implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 职位
    */
    @ApiModelProperty(value="职位")
    private String name;

    @ApiModelProperty(value="")
    private LocalDateTime createdate;

    @ApiModelProperty(value="")
    private Boolean enabled;

    private static final long serialVersionUID = 1L;
}