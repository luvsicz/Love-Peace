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
 * @ClassName Employeetrain.java
 * @createTime 2020年04月04日 15:47:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Employeetrain implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  /**
   * 员工编号
   */

  private Integer eid;
  /**
   * 培训日期
   */

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
  private Timestamp trainDate;
  /**
   * 培训内容
   */

  private String trainContent;
  /**
   * 备注
   */

  private String remark;
  private String name;
}