package org.dev.hrm.service;

import javax.annotation.Resource;
import org.dev.hrm.mapper.MenuRoleMapper;
import org.dev.hrm.model.MenuRole;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName MenuRoleService.java
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class MenuRoleService {

  @Resource
  private MenuRoleMapper menuRoleMapper;


  public int deleteByPrimaryKey(Integer id) {
    return menuRoleMapper.deleteByPrimaryKey(id);
  }


  public int insert(MenuRole record) {
    return menuRoleMapper.insert(record);
  }


  public int insertSelective(MenuRole record) {
    return menuRoleMapper.insertSelective(record);
  }


  public MenuRole selectByPrimaryKey(Integer id) {
    return menuRoleMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(MenuRole record) {
    return menuRoleMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(MenuRole record) {
    return menuRoleMapper.updateByPrimaryKey(record);
  }

}
