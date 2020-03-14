package org.dev.hrm.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Hr.java
 * @Description Hr
 * @createTime 2019年12月29日 22:03:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hr implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * hrID
   */
  private Integer id;
  /**
   * 姓名
   */
  private String name;
  /**
   * 手机号码
   */
  private String phone;
  /**
   * 住宅电话
   */
  private String telephone;
  /**
   * 联系地址
   */
  private String address;
  private Boolean enabled;
  /**
   * 用户名
   */
  private String username;
  /**
   * 密码
   */
  private String password;
  private String userface;
  private String remark;

  public static HrBuilder builder() {
    return new HrBuilder();
  }
}