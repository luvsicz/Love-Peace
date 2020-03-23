package org.dev.hrm.model;

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
 * @ClassName Joblevel.java
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value = "org-dev-hrm-model-Joblevel")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Joblevel implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty(value = "")
  private Integer id;
  /**
   * 职称名称
   */
  @ApiModelProperty(value = "职称名称")
  private String name;

  @ApiModelProperty(value = "")
  private String titlelevel;

  @ApiModelProperty(value = "")
  private Date createdate;

  @ApiModelProperty(value = "")
  private Boolean enabled;

  public Joblevel(String name) {

    this.name = name;
  }
}