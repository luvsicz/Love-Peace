package org.dev.hrm.model;


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
 * @ClassName EmployeeRemove.java
 * @createTime 2020年04月04日 15:14:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EmployeeRemove implements Serializable {


  private Integer id;


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

  private Date removeDate;

  /**
   * 调动原因
   */

  private String reason;


  private String remark;

  private static final long serialVersionUID = 1L;
}