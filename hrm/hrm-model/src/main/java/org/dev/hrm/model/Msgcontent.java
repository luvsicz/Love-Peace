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
 * @ClassName Msgcontent.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value="org-dev-hrm-model-Msgcontent")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Msgcontent implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private String title;

    @ApiModelProperty(value="")
    private String message;

    @ApiModelProperty(value="")
    private LocalDateTime createdate;

    private static final long serialVersionUID = 1L;
}