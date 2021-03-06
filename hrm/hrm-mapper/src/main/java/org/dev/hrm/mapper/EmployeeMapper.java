package org.dev.hrm.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.Employee;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmployeeMapper.java
 * @createTime 2020年03月18日 15:49:00
 */
@Mapper
public interface EmployeeMapper {


  int deleteByPrimaryKey(Integer id);

  int insert(Employee record);

  int insertSelective(Employee record);


  Employee selectByPrimaryKey(Integer id);


  int updateByPrimaryKeySelective(Employee record);

  int updateByPrimaryKey(Employee record);

  List<Employee> getEmployeeByPage(@Param("page") Integer page,
                                   @Param("size") Integer size,
                                   @Param("emp") Employee emp,
                                   @Param("beginDateScope") Date[] beginDateScope);

  int deleteByPrimaryKeys(@Param("ids") String[] ids);

  long getTotal(@Param("emp") Employee emp,
                @Param("beginDateScope") Date[] beginDateScope,
                @Param("depId") Integer depId);

  Integer getMaxWorkerId();

  List<Employee> getEmployeeByPageWithSalary(@Param("page") Integer page,
                                             @Param("size") Integer size,
                                             @Param("depId") Integer depId,
                                             @Param(
                                                 "name") String name);

  Integer updateEmployeeSalaryById(@Param("eid") Integer eid,
                                   @Param("sid") Integer sid);

  List<Employee> selectByPrimaryKeys(@Param("ids") String[] ids);
}