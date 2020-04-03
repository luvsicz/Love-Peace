package org.dev.hrm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName MsgContent.java
 * @createTime 2020年04月01日 15:21:00
 */
@ApiModel(value = "org-dev-hrm-model-MsgContent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgContent implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty(value = "")
  private Integer id;
  @ApiModelProperty(value = "")
  private String title;
  @ApiModelProperty(value = "")
  private String message;
  @ApiModelProperty(value = "")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
  private LocalDateTime createDate;
}