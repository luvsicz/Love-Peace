package org.dev.hrm.model;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName HrRole.java
 * @createTime 2020年03月18日 15:49:00
 */

@Data

@AllArgsConstructor
@NoArgsConstructor
public class HrRole implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private Integer hrid;

  private Integer rid;
}