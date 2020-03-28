package org.dev.hrm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.HrRole;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName HrRoleMapper.java
 * @createTime 2020年03月18日 15:49:00
 */
@Mapper
public interface HrRoleMapper {


  int deleteByPrimaryKey(Integer id);

  int insert(HrRole record);

  int insertSelective(HrRole record);


  HrRole selectByPrimaryKey(Integer id);


  int updateByPrimaryKeySelective(HrRole record);

  int updateByPrimaryKey(HrRole record);

  int insertHrWithRoles(@Param("hrId") Integer hrid, @Param("rids") Integer[] rids);
}