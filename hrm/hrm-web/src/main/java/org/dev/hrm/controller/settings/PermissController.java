package org.dev.hrm.controller.settings;

import java.util.List;
import org.dev.hrm.model.Menu;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.model.Role;
import org.dev.hrm.service.MenuService;
import org.dev.hrm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

  @Autowired
  RoleService roleService;
  @Autowired
  MenuService menuService;

  @GetMapping("/")
  public List<Role> getAllRoles() {
    return roleService.getAllRoles();
  }

  @GetMapping("/menus")
  public List<Menu> getAllMenus() {
    return menuService.getAllMenus();
  }

  @GetMapping("/mids/{rid}")
  public List<Integer> getMidsByRid(@PathVariable Integer rid) {
    return menuService.getMenuIdByRoleId(rid);
  }

  @PutMapping("/")
  public RespBean updateMenuRole(Integer rid, Integer[] mids) {
    if (menuService.updateMenuRole(rid, mids)) {
      return RespBean.ok("更新成功!");
    }
    return RespBean.error("更新失败!");
  }

  @PostMapping("/role")
  public RespBean addRole(@RequestBody Role role) {
    if (roleService.addRole(role) == 1) {
      return RespBean.ok("添加成功!");
    }
    return RespBean.error("添加失败!");
  }

  @DeleteMapping("/role/{rid}")
  public RespBean deleteRoleById(@PathVariable Integer rid) {
    if (roleService.deleteByPrimaryKey(rid) == 1) {
      return RespBean.ok("删除成功!");
    }
    return RespBean.error("删除失败!");
  }
}
