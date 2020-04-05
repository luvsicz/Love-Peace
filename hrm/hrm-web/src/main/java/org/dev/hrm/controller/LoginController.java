package org.dev.hrm.controller;

import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

  @Autowired
  HrService hrService;

  @PostMapping("/hr/reg")
  @WebLogger
  public RespBean hrReg(String username, String password) {
    //先判断用户名是否存在
    if (hrService.loadUserByUsername(username) != null) {
      return RespBean.error("用户名已存在，换一个吧！");
    }
    //密码加密然后插入HR表
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String encode = encoder.encode(password);
    Hr regHr = new Hr();
    regHr.setUsername(username);
    regHr.setPassword(password);
    return hrService.insertSelective(regHr) == 1 ? RespBean.ok("注册成功，请登录！") :
        RespBean.error("注册失败，请联系管理员!");
  }


}
