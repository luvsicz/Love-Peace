package org.dev.hrm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Position.java
 * @createTime 2020年03月18日 15:49:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  /**
   * 职位
   */

  private String name;


  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Date createDate;


  private Boolean enabled;

  public Position(String name) {

    this.name = name;
  }
}