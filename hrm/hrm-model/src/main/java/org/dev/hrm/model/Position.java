package org.dev.hrm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Position.java
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value = "org-dev-hrm-model-Position")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Position implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty(value = "")
  private Integer id;
  /**
   * 职位
   */
  @ApiModelProperty(value = "职位")
  private String name;

  @ApiModelProperty(value = "")
 @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date createdate;

  @ApiModelProperty(value = "")
  private Boolean enabled;

  public Position(String name) {

    this.name = name;
  }
}