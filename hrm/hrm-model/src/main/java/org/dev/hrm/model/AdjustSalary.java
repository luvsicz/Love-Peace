package org.dev.hrm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName AdjustSalary.java
 * @createTime 2020年04月09日 15:32:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AdjustSalary implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id;
  private Employee employee;
  private Integer eid;
  /**
   * 调薪日期
   */
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Date asDate;
  /**
   * 调前额度
   */
  private Integer amount;
  /**
   * 调薪原因
   */
  private String reason;
  /**
   * 备注
   */
  private String remark;

}