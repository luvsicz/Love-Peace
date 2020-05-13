package org.dev.hrm.controller.hr;

import java.util.Map;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName HrController.java
 * @createTime 2020年03月22日 17:30:00
 */
@RestController
@RequestMapping("/hr/")
public class HrController {

  @Autowired
  HrService hrService;

  @GetMapping("/info")
  @WebLogger
  public Hr getCurrentHr(Authentication authentication) {
    return ((Hr) authentication.getPrincipal());
  }

  @PutMapping("/info")
  @WebLogger
  public RespBean updateHr(@RequestBody Hr hr, Authentication authentication) {
    if (hrService.updateByPrimaryKeySelective(hr) == 1) {
      //如果更新成功则把参数hr更新到Authentication
      SecurityContextHolder.getContext().setAuthentication(
          new UsernamePasswordAuthenticationToken(hr, authentication.getCredentials(),
              authentication.getAuthorities()));
      return RespBean.ok("更新成功!");
    }
    return RespBean.error("更新失败!");
  }

  @PutMapping("/password")
  @WebLogger
  public RespBean updateHrPasswd(@RequestBody Map<String, Object> info) {
    String oldpass = (String) info.get("oldpass");
    String pass = (String) info.get("pass");
    Integer hrid = (Integer) info.get("hrid");
    if (hrService.updateHrPassById(oldpass, pass, hrid)) {
      return RespBean.ok("密码更新成功!");
    }
    return RespBean.error("密码更新失败，检查旧密码是否正确!");
  }
}
