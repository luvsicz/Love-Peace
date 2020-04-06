package org.dev.hrm.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.dev.hrm.config.VerificationCodeConfig;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @GetMapping("/verifyCode")
  public void verifyCode(HttpServletRequest request, HttpServletResponse resp)
      throws IOException {
    VerificationCodeConfig code = new VerificationCodeConfig();
    BufferedImage image = code.getImage();
    String text = code.getText();
    HttpSession session = request.getSession(true);
    session.setAttribute("verify_code", text);
    VerificationCodeConfig.output(image, resp.getOutputStream());
  }

  @PostMapping("/reg")
  public RespBean hrReg(@RequestBody Hr hr) {
    //先判断用户名是否存在
    try {
      if (hrService.loadUserByUsername(hr.getUsername()) != null) {
        return RespBean.error("用户名已存在，换一个吧！");
      }
    } catch (UsernameNotFoundException exception) {
      //密码加密然后插入HR表
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      String encode = encoder.encode(hr.getPassword());
      Hr regHr = new Hr();
      regHr.setUsername(hr.getUsername());
      regHr.setPassword(encode);
      return hrService.insertSelective(regHr) == 1 ? RespBean.ok("注册成功，请登录！") :
          RespBean.error("注册失败，请联系管理员!");
    }

    return RespBean.error("注册失败，请联系管理员!");
  }


}
