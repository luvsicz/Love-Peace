package org.dev.hrm.model;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName PoliticsStatus.java
 * @createTime 2020年03月24日 15:50:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliticsStatus implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String name;

  public PoliticsStatus(String name) {

    this.name = name;
  }
}