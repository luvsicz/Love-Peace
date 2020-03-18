package org.dev.hrm.controller;

import java.util.Map;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @时间 2020-03-01 13:07
 */
@RestController
public class HrInfoController {

  @Autowired
  HrService hrService;


  @RequestMapping("/hello/m")
  public void updateHr() {
  }

  @PutMapping("/hr/pass")
  public RespBean updateHrPasswd(@RequestBody Map<String, Object> info) {
    String oldPass = (String) info.get("oldpass");
    String newPass = (String) info.get("pass");
    Integer hrId = (Integer) info.get("hrid");
    if (hrService.updateHrPassById(oldPass, newPass, hrId)) {
      return RespBean.ok("更新成功!");
    }
    return RespBean.error("更新失败!");
  }
}