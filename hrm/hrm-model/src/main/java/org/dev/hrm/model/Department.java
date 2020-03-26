package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Department.java
 * @Description TODO
 * @createTime 2020年03月23日 19:57:00
 */
@ApiModel(value = "org-dev-hrm-model-Department")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty(value = "")
  private Integer id;
  /**
   * 部门名称
   */
  @ApiModelProperty(value = "部门名称")
  private String name;
  @ApiModelProperty(value = "")
  private Integer parentId;
  @ApiModelProperty(value = "")
  private String depPath;
  @ApiModelProperty(value = "")
  private Boolean enabled;
  @ApiModelProperty(value = "")
  private Boolean isParent;
  @ApiModelProperty(value = "")
  private Integer result;
  @ApiModelProperty(value = "")
  private List<Department> children = new ArrayList<>();

  public Department(String name) {

    this.name = name;
  }
}