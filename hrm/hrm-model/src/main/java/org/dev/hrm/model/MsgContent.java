package org.dev.hrm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgContent implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String title;

  private String message;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
  private LocalDateTime createDate;
}