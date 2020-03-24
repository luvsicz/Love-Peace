package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PoliticsStatus.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月24日 15:50:00
 */
@ApiModel(value="org-dev-hrm-model-PoliticsStatus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliticsStatus implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private String name;
    public PoliticsStatus(String name) {

        this.name = name;
    }
    private static final long serialVersionUID = 1L;
}