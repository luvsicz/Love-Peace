package com.rechar.campusassistant.bean;

import androidx.annotation.Nullable;

/**
 * @author Bamboo
 * @package:com.rechar.campusassistant.bean
 * @fileName:User
 * @date on:2019/11/13 14:13
 */
public class User {
  @Nullable
  private String userName;
  @Nullable
  private String passWord;

  private boolean isDataValid;

  public User(@Nullable String userName, @Nullable String passWord) {
    this.userName = userName;
    this.passWord = passWord;
    this.isDataValid = false;
  }

  @Nullable
  public String getUserName() {
    return userName;
  }

  public void setUserName(@Nullable String userName) {
    this.userName = userName;
  }

  @Nullable
  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(@Nullable String passWord) {
    this.passWord = passWord;
  }

  public boolean isDataValid() {
    return isDataValid;
  }

  public void setDataValid(boolean dataValid) {
    isDataValid = dataValid;
  }
}
