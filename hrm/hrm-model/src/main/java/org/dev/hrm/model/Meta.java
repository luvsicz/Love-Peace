package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Meta.java
 * @Description TODO
 * @createTime 2020年03月18日 16:22:00
 */
@ApiModel(value = "org-dev-hrm-model-Meta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta {

  @ApiModelProperty(value = "")
  private Boolean keepAlive;
  @ApiModelProperty(value = "")
  private Boolean requireAuth;

}
