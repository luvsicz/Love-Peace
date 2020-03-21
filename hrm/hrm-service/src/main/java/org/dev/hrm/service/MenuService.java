package org.dev.hrm.service;

import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.MenuMapper;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.Menu;
import org.dev.hrm.model.MenuExample;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName MenuService.java
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
@CacheConfig(cacheNames = "menuService")
public class MenuService {

  @Resource
  private MenuMapper menuMapper;


  public long countByExample(MenuExample example) {
    return menuMapper.countByExample(example);
  }


  public int deleteByExample(MenuExample example) {
    return menuMapper.deleteByExample(example);
  }


  public int deleteByPrimaryKey(Integer id) {
    return menuMapper.deleteByPrimaryKey(id);
  }


  public int insert(Menu record) {
    return menuMapper.insert(record);
  }


  public int insertSelective(Menu record) {
    return menuMapper.insertSelective(record);
  }


  public List<Menu> selectByExample(MenuExample example) {
    return menuMapper.selectByExample(example);
  }


  public Menu selectByPrimaryKey(Integer id) {
    return menuMapper.selectByPrimaryKey(id);
  }


  public int updateByExampleSelective(Menu record, MenuExample example) {
    return menuMapper.updateByExampleSelective(record, example);
  }


  public int updateByExample(Menu record, MenuExample example) {
    return menuMapper.updateByExample(record, example);
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

}
