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
 * @ClassName Sysmsg.java
 * @createTime 2020年04月01日 15:20:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Sysmsg implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  /**
   * 消息id
   */

  private Integer mid;
  /**
   * 0表示群发消息
   */

  private Integer type;
  /**
   * 这条消息是给谁的
   */

  private Integer hrid;
  /**
   * 0 未读 1 已读
   */

  private Integer state;

  private String title;

  private String message;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
  private Timestamp createDate;
}