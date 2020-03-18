package org.dev.hrm.controller;

import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.RespBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName LoginController.java
 * @Description 登录
 * @createTime 2020年03月16日 17:30:00
 */
@RestController
public class LoginController {

  @PostMapping("/login")
  @WebLogger
  public RespBean login() {
    return RespBean.ok("登陆成功");
  }

}
