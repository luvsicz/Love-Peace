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
 * @ClassName Sysmsg.java
 * @createTime 2020年04月01日 15:20:00
 */
@ApiModel(value = "org-dev-hrm-model-Sysmsg")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sysmsg implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty(value = "")
  private Integer id;
  /**
   * 消息id
   */
  @ApiModelProperty(value = "消息id")
  private Integer mid;
  /**
   * 0表示群发消息
   */
  @ApiModelProperty(value = "0表示群发消息")
  private Integer type;
  /**
   * 这条消息是给谁的
   */
  @ApiModelProperty(value = "这条消息是给谁的")
  private Integer hrid;
  /**
   * 0 未读 1 已读
   */
  @ApiModelProperty(value = "0 未读 1 已读")
  private Integer state;
  @ApiModelProperty(value = "标题")
  private String title;
  @ApiModelProperty(value = "")
  private String message;
  @ApiModelProperty(value = "")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
  private LocalDateTime createDate;
}