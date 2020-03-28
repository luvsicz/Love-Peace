package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.dev.hrm.model.Role;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName RoleMapper.java
 * @createTime 2020年03月26日 21:59:00
 */
@Mapper
public interface RoleMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(Role record);

  int insertSelective(Role record);

  Role selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Role record);

  int updateByPrimaryKey(Role record);

  List<Role> getAllRoles();
}