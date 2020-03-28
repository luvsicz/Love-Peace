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
 * @ClassName JobLevel.java
 * @createTime 2020年03月24日 15:56:00
 */
@ApiModel(value = "org-dev-hrm-model-JobLevel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobLevel implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty(value = "")
  private Integer id;
  /**
   * 职称名称
   */
  @ApiModelProperty(value = "职称名称")
  private String name;
  @ApiModelProperty(value = "")
  private Object titleLevel;
  @ApiModelProperty(value = "")
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Date createDate;
  @ApiModelProperty(value = "")
  private Boolean enabled;

  public JobLevel(String name) {

    this.name = name;
  }
}