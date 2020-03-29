package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.RespPageBean;
import org.dev.hrm.model.Salary;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName SalaryMapper.java

 * @createTime 2020年03月29日 15:17:00
 */
@Mapper
public interface SalaryMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(Salary record);

  int insertSelective(Salary record);

  Salary selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Salary record);

  int updateByPrimaryKey(Salary record);

  List<Salary> getAllSalaries();

  RespPageBean getDepsSalaryTable(@Param("page") Integer page,@Param("size")  Integer size,@Param("depId")  Integer depId);
}