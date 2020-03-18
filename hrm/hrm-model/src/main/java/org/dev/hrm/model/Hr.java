package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Hr.java
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value = "org-dev-hrm-model-Hr")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hr implements UserDetails {

  private static final long serialVersionUID = 1L;
  /**
   * hrID
   */
  @ApiModelProperty(value = "hrID")
  private Integer id;
  /**
   * 姓名
   */
  @ApiModelProperty(value = "姓名")
  private String name;
  /**
   * 手机号码
   */
  @ApiModelProperty(value = "手机号码")
  private String phone;
  /**
   * 住宅电话
   */
  @ApiModelProperty(value = "住宅电话")
  private String telephone;
  /**
   * 联系地址
   */
  @ApiModelProperty(value = "联系地址")
  private String address;
  @ApiModelProperty(value = "")
  private Boolean enabled;
  /**
   * 用户名
   */
  @ApiModelProperty(value = "用户名")
  private String username;
  /**
   * 密码
   */
  @ApiModelProperty(value = "密码")
  private String password;
  @ApiModelProperty(value = "")
  private String userface;
  @ApiModelProperty(value = "")
  private String remark;
  @ApiModelProperty(value = "")
  private List<Role> roles;

  public static HrBuilder builder() {
    return new HrBuilder();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authorities = new ArrayList<>(roles.size());
    for (Role role : roles) {
      authorities.add(new SimpleGrantedAuthority(role.getName()));
    }
    return authorities;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}