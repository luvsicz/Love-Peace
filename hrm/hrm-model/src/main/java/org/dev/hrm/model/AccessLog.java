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
 * @ClassName AccessLog.java
 * @createTime 2020年04月06日 15:49:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AccessLog implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * 主键
   */

  private Integer id;
  /**
   * 类名
   */

  private String className;
  /**
   * 请求的方法
   */

  private String requestMethod;
  /**
   * Content-Type
   */

  private String contentType;
  /**
   * 请求所带的参数
   */

  private String requestParams;
  /**
   * 请求类型Restful
   */

  private String requestType;
  /**
   * 服务端地址
   */

  private String serverAddr;
  /**
   * 客户端地址
   */

  private String remoteAddr;
  /**
   * 设备名
   */

  private String deviceName;
  /**
   * 浏览器名称
   */

  private String browserName;
  /**
   * UserAgent
   */

  private String userAgent;
  /**
   * 请求的Uri
   */

  private String requestUri;
  /**
   * 发起请求的时间
   */

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
  private Timestamp requestTime;
  /**
   * hrID
   */

  private Integer hrid;


  private String name;
}