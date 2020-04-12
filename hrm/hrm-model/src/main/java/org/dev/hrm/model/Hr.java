package org.dev.hrm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Hr.java
 * @createTime 2020年03月18日 15:49:00
 */

@AllArgsConstructor
@NoArgsConstructor
//@Data使用data 会导致Mybatis调用getter setter方法的时候 抛异常，找不到使用 enable属性的哪个方法。
public class Hr implements UserDetails {

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

  private List<Role> roles;

  @Override
  @JsonIgnore
  //Type definition error: [simple type, class org.springframework.security.core.GrantedAuthority];
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

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserface() {
    return userface;
  }

  public void setUserface(String userface) {
    this.userface = userface;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }
}