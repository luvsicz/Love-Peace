package org.dev.hrm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.MenuRole;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName MenuRoleMapper.java
 * @createTime 2020年03月18日 15:49:00
 */
@Mapper
public interface MenuRoleMapper {


  int deleteByPrimaryKey(Integer id);

  int insert(MenuRole record);

  int insertSelective(MenuRole record);


  MenuRole selectByPrimaryKey(Integer id);


  int updateByPrimaryKeySelective(MenuRole record);

  int updateByPrimaryKey(MenuRole record);

  int deleteByRoleId(@Param("rid") Integer rid);

  Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);

}