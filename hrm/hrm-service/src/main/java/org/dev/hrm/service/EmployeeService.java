package org.dev.hrm.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.dev.hrm.mapper.EmployeeMapper;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.EmployeeExample;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmployeeService.java
 * @Description EmployeeService
 * @createTime 2019年12月29日 23:16:00
 */
@Service
@AllArgsConstructor
public class EmployeeService {

  private EmployeeMapper employeeMapper;


  public long countByExample(EmployeeExample example) {
    return employeeMapper.countByExample(example);
  }


  public int deleteByExample(EmployeeExample example) {
    return employeeMapper.deleteByExample(example);
  }


  public int deleteByPrimaryKey(Integer id) {
    return employeeMapper.deleteByPrimaryKey(id);
  }


  public int insert(Employee record) {
    return employeeMapper.insert(record);
  }


  public int insertSelective(Employee record) {
    return employeeMapper.insertSelective(record);
  }


  public List<Employee> selectByExample(EmployeeExample example) {
    return employeeMapper.selectByExample(example);
  }


  public Employee selectByPrimaryKey(Integer id) {
    return employeeMapper.selectByPrimaryKey(id);
  }


  public int updateByExampleSelective(Employee record, EmployeeExample example) {
    return employeeMapper.updateByExampleSelective(record, example);
  }


  public int updateByExample(Employee record, EmployeeExample example) {
    return employeeMapper.updateByExample(record, example);
  }


  public int updateByPrimaryKeySelective(Employee record) {
    return employeeMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(Employee record) {
    return employeeMapper.updateByPrimaryKey(record);
  }

}


