package org.dev.hrm.model;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Role.java
 * @createTime 2020年03月26日 21:59:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String name;
  /**
   * 角色名称
   */

  private String nameZh;
}