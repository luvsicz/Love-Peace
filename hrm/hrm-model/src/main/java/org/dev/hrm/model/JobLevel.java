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
 * @ClassName JobLevel.java
 * @createTime 2020年03月24日 15:56:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobLevel implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  /**
   * 职称名称
   */

  private String name;

  private Object titleLevel;

  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Date createDate;

  private Boolean enabled;

  public JobLevel(String name) {

    this.name = name;
  }
}