package org.dev.hrm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Employeetrain.java
 * @createTime 2020年04月04日 15:47:00
 */
@ApiModel(value = "org-dev-hrm-model-Employeetrain")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employeetrain implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty(value = "")
  private Integer id;
  /**
   * 员工编号
   */
  @ApiModelProperty(value = "员工编号")
  private Integer eid;
  /**
   * 培训日期
   */
  @ApiModelProperty(value = "培训日期")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
  private Timestamp trainDate;
  /**
   * 培训内容
   */
  @ApiModelProperty(value = "培训内容")
  private String trainContent;
  /**
   * 备注
   */
  @ApiModelProperty(value = "备注")
  private String remark;
  private String name;
}