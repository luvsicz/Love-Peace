package org.dev.hrm.model;


import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Adjustsalary.java
 * @createTime 2020年04月02日 20:14:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adjustsalary implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id;
  private Integer eid;
  /**
   * 调薪日期
   */

  private LocalDate asDate;
  /**
   * 调前薪资
   */

  private Integer beforeSalary;
  /**
   * 调后薪资
   */

  private Integer afterSalary;
  /**
   * 调薪原因
   */

  private String reason;
  /**
   * 备注
   */

  private String remark;
}