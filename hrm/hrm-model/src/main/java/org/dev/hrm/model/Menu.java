package org.dev.hrm.model;


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

@Data

@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String url;

  private String path;

  private String component;

  private String name;

  private String iconCls;

  private Boolean keepAlive;

  private Boolean requireAuth;

  private Integer parentId;

  private Boolean enabled;

  private List<Menu> children;

  private List<Role> roles;

  private Meta meta;


}