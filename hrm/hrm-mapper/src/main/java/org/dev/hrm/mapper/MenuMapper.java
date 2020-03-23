package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.Menu;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName MenuMapper.java
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Mapper
public interface MenuMapper {


  int deleteByPrimaryKey(Integer id);

  int insert(Menu record);

  int insertSelective(Menu record);


  Menu selectByPrimaryKey(Integer id);


  int updateByPrimaryKeySelective(Menu record);

  int updateByPrimaryKey(Menu record);

  List<Menu> getAllMenusWithRole();

  /**
   * 根据HrId返回当前角色的菜单
   *
   * @param hrId
   * @return MenuList
   */
  List<Menu> getMenusByHrId(@Param("hrId") Integer hrId);
}