package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Menu.java
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value = "org-dev-hrm-model-Menu")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty(value = "")
  private Integer id;
  @ApiModelProperty(value = "")
  private String url;
  @ApiModelProperty(value = "")
  private String path;
  @ApiModelProperty(value = "")
  private String component;
  @ApiModelProperty(value = "")
  private String name;
  @ApiModelProperty(value = "")
  private String iconCls;
  @ApiModelProperty(value = "")
  private Boolean keepAlive;
  @ApiModelProperty(value = "")
  private Boolean requireAuth;
  @ApiModelProperty(value = "")
  private Integer parentId;
  @ApiModelProperty(value = "")
  private Boolean enabled;
  @ApiModelProperty(value = "")
  private List<Menu> children;
  @ApiModelProperty(value = "")
  private List<Role> roles;
  @ApiModelProperty(value = "")
  private Meta meta;


}