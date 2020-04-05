package org.dev.hrm.service;

import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.MenuMapper;
import org.dev.hrm.mapper.MenuRoleMapper;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.Menu;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName MenuService.java
 * @createTime 2020年03月18日 15:49:00
 */
@Service
@CacheConfig(cacheNames = "menuService")
public class MenuService {

  @Resource
  MenuRoleMapper menuRoleMapper;
  @Resource
  private MenuMapper menuMapper;

  public int deleteByPrimaryKey(Integer id) {
    return menuMapper.deleteByPrimaryKey(id);
  }


  public int insert(Menu record) {
    return menuMapper.insert(record);
  }


  public int insertSelective(Menu record) {
    return menuMapper.insertSelective(record);
  }


  public Menu selectByPrimaryKey(Integer id) {
    return menuMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(Menu record) {
    return menuMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(Menu record) {
    return menuMapper.updateByPrimaryKey(record);
  }

  /**
   * 用方法名作为缓存的key
   *
   * @return 菜单和角色信息
   */
  @Cacheable(key = "#root.method.name")
  public List<Menu> getAllMenusWithRole() {
    return menuMapper.getAllMenusWithRole();
  }

  public List<Menu> getMenusByHrId() {
    return menuMapper.getMenusByHrId(
        ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
  }

  public List<Menu> getAllMenus() {

    return menuMapper.getAllMenus();
  }

  public List<Integer> getMenuIdByRoleId(Integer rid) {
    return menuMapper.getMenuIdByRoleId(rid);
  }

  /**
   * 异常则RollBack
   *
   * @param rid  角色ID
   * @param mids 菜单ID数组
   * @return true/false
   */
  @Transactional(rollbackFor = Exception.class)
  public boolean updateMenuRole(Integer rid, Integer[] mids) {
    menuRoleMapper.deleteByRoleId(rid);
    if (mids == null || mids.length == 0) {
      return true;
    }
    Integer result = menuRoleMapper.insertRecord(rid, mids);
    return result == mids.length;
  }
}
