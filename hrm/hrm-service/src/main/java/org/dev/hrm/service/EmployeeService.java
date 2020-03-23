package org.dev.hrm.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.mapper.EmployeeMapper;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.EmployeeExample;
import org.dev.hrm.model.RespPageBean;
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

  public int deleteByPrimaryKeys(String ids) {
    String[] id = ids.split(",");
    return employeeMapper.deleteByPrimaryKeys(id);
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

  public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee emp) {
    if (page != null && size != null) {
      page = (page - 1) * size;
    }
    List<Employee> data = employeeMapper.getEmployeeByPage(page, size, emp);
    long total = employeeMapper.getTotal(emp);
    RespPageBean pageBean = new RespPageBean();
    pageBean.setTotal(total);
    pageBean.setData(data);
    return pageBean;
  }
}


