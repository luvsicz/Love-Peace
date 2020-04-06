package org.dev.hrm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Oplog.java
 * @createTime 2020年04月06日 14:36:00
 */
@ApiModel(value = "org-dev-hrm-model-Oplog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oplog implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty(value = "")
  private Integer id;
  /**
   * 操作日期
   */
  @ApiModelProperty(value = "操作日期")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
  private Timestamp opDate;
  /**
   * 操作内容
   */
  @ApiModelProperty(value = "操作内容")
  private String operate;
  /**
   * 操作员ID
   */
  @ApiModelProperty(value = "操作员ID")
  private Integer hrid;
  /**
   * 访问的URI
   */
  @ApiModelProperty(value = "访问的URI")
  private String uri;

  private String name;
}