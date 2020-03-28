package org.dev.hrm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dev.hrm.model.Salary;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName SalaryMapper.java
 * @createTime 2020年03月18日 15:49:00
 */
@Mapper
public interface SalaryMapper {


  int deleteByPrimaryKey(Integer id);

  int insert(Salary record);

  int insertSelective(Salary record);


  Salary selectByPrimaryKey(Integer id);


  int updateByPrimaryKeySelective(Salary record);

  int updateByPrimaryKey(Salary record);
}