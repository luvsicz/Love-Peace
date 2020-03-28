package org.dev.hrm.controller.sys;

import java.util.List;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.model.Role;
import org.dev.hrm.service.HrService;
import org.dev.hrm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName HrRolesController.java
 * @createTime 2020年03月27日 20:48:00
 */
@RestController
@RequestMapping("/sys/hr")
public class HrRolesController {

  @Autowired
  HrService hrService;
  @Autowired
  RoleService roleService;

  @GetMapping("/")
  public List<Hr> getHrs(String keywords) {
    //获取除了当前HR以外的HR信息
    return hrService.selectByNameLikeKeyWords(keywords);
  }

  @PutMapping("/")
  public RespBean updateHr(@RequestBody Hr hr) {
    if (hrService.updateByPrimaryKeySelective(hr) == 1) {
      return RespBean.ok("更新成功!");
    }
    return RespBean.error("更新失败!");
  }

  @GetMapping("/roles")
  public List<Role> getAllRoles() {
    return roleService.getAllRoles();
  }

  @PutMapping("/role")
  public RespBean updateHrRole(Integer hrid, Integer[] rids) {
    if (hrService.updateHrRole(hrid, rids)) {
      return RespBean.ok("更新成功!");
    }
    return RespBean.error("更新失败!");
  }

  @DeleteMapping("/{id}")
  public RespBean deleteHrById(@PathVariable Integer id) {
    if (hrService.deleteByPrimaryKey(id) == 1) {
      return RespBean.ok("删除成功!");
    }
    return RespBean.error("删除失败!");
  }
}
