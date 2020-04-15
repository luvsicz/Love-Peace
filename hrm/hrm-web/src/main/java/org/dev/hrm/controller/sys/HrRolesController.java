package org.dev.hrm.controller.sys;

import java.util.List;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.model.Role;
import org.dev.hrm.service.HrService;
import org.dev.hrm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
  @WebLogger
  public List<Hr> getHrs(String keywords) {
    //获取除了当前HR以外的HR信息
    return hrService.selectByNameLikeKeyWords(keywords);
  }

  /**
   * 更新完成后清理所有缓存
   *
   * @param hr
   * @return
   */
  @PutMapping("/")
  @WebLogger
  @CacheEvict(value = "menuService", allEntries = true)
  public RespBean updateHr(@RequestBody Hr hr) {
    if (hrService.updateByPrimaryKeySelective(hr) == 1) {
      return RespBean.ok("更新成功!");
    }
    return RespBean.error("更新失败!");
  }

  @GetMapping("/roles")
  @WebLogger
  public List<Role> getAllRoles() {
    return roleService.getAllRoles();
  }

  @PutMapping("/role")
  @WebLogger
  @CacheEvict(value = "menuService", allEntries = true)
  public RespBean updateHrRole(Integer hrid, Integer[] rids) {
    //前端设置rids为-1则清空用户权限
    if (rids[0] == -1) {
      if (hrService.deleteAllRolesByHrid(hrid) > 0) {
        return RespBean.ok("权限清空成功!");
      } else {
        return RespBean.error("权限清空失败!");
      }
    }
    if (hrService.updateHrRole(hrid, rids)) {
      return RespBean.ok("更新成功!");
    }
    return RespBean.error("更新失败!");
  }

  @DeleteMapping("/{id}")
  @WebLogger
  @CacheEvict(value = "menuService", allEntries = true)
  public RespBean deleteHrById(@PathVariable Integer id) {
    if (hrService.deleteByPrimaryKey(id) == 1) {
      return RespBean.ok("删除成功!");
    }
    return RespBean.error("删除失败!");
  }
}
