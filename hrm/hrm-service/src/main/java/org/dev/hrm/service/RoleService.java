package org.dev.hrm.service;

import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.RoleMapper;
import org.dev.hrm.model.Role;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName RoleService.java
 * @Description TODO
 * @createTime 2020年03月26日 21:59:00
 */
@Service
public class RoleService {

  @Resource
  private RoleMapper roleMapper;


  public int deleteByPrimaryKey(Integer id) {
    return roleMapper.deleteByPrimaryKey(id);
  }


  public int insert(Role record) {
    return roleMapper.insert(record);
  }


  public int insertSelective(Role record) {
    return roleMapper.insertSelective(record);
  }


  public Role selectByPrimaryKey(Integer id) {
    return roleMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(Role record) {
    return roleMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(Role record) {
    return roleMapper.updateByPrimaryKey(record);
  }

  public List<Role> getAllRoles() {
    return roleMapper.getAllRoles();
  }

  public Integer addRole(Role role) {
    if (!role.getName().startsWith("ROLE_")) {
      role.setName("ROLE_" + role.getName());
    }
    return roleMapper.insert(role);
  }
}
