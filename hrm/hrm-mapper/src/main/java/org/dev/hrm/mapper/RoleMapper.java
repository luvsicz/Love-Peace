package org.dev.hrm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dev.hrm.model.Role;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName RoleMapper.java
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Mapper
public interface RoleMapper {


  int deleteByPrimaryKey(Integer id);

  int insert(Role record);

  int insertSelective(Role record);


  Role selectByPrimaryKey(Integer id);


  int updateByPrimaryKeySelective(Role record);

  int updateByPrimaryKey(Role record);
}