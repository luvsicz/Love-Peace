package org.dev.hrm.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
 * @createTime 2020年03月23日 19:57:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Department implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  /**
   * 部门名称
   */

  private String name;

  private Integer parentId;

  private String depPath;

  private Boolean enabled;

  private Boolean isParent;

  private Integer result;

  private List<Department> children = new ArrayList<>();

  public Department(String name) {

    this.name = name;
  }
}