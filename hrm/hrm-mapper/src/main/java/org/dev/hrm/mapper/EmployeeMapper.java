package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.EmployeeExample;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmployeeMapper.java
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Mapper
public interface EmployeeMapper {

  long countByExample(EmployeeExample example);

  int deleteByExample(EmployeeExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(Employee record);

  int insertSelective(Employee record);

  List<Employee> selectByExample(EmployeeExample example);

  Employee selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") Employee record,
      @Param("example") EmployeeExample example);

  int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

  int updateByPrimaryKeySelective(Employee record);

  int updateByPrimaryKey(Employee record);

  List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size,
      @Param("keyword") String keyword);
}