package org.dev.hrm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmployeeTransfer.java
 * @createTime 2020年04月08日 13:27:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EmployeeTransfer implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * 职称等级
   */
  private JobLevel jobLevel;
  /**
   * 职位
   */
  private Position position;
  /**
   * 主键
   */
  private Integer id;
  /**
   * 员工实体
   */
  private Employee employee;
  /**
   * 员工ID
   */
  private Integer eid;
  /**
   * 调动后部门
   */
  private Integer afterDepId;
  /**
   * 调动后职位
   */
  private Integer afterJobId;
  /**
   * 调动日期
   */
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Timestamp removeDate;
  /**
   * 调动原因
   */
  private String reason;
  /**
   * 备注信息
   */
  private String remark;
  /**
   * 调动后的职称
   */
  private Integer afterLevelId;
  /**
   * 部门
   */
  private Department department;
  /**
   * 调用结果
   */
  private Integer result;
  /**
   * 是否已完成
   */
  private boolean finished;

}