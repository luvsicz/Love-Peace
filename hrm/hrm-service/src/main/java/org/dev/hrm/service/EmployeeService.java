package org.dev.hrm.service;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import org.dev.hrm.mapper.EmployeeMapper;
import org.dev.hrm.model.Employee;
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


  public Employee selectByPrimaryKey(Integer id) {
    return employeeMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(Employee record) {
    return employeeMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(Employee record) {
    return employeeMapper.updateByPrimaryKey(record);
  }

  public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee emp,
      Date[] beginDateScope) {
    if (page != null && size != null) {
      page = (page - 1) * size;
    }
    List<Employee> data = employeeMapper.getEmployeeByPage(page, size, emp, beginDateScope);
    long total = employeeMapper.getTotal(emp, beginDateScope);
    RespPageBean pageBean = new RespPageBean();
    pageBean.setTotal(total);
    pageBean.setData(data);
    return pageBean;
  }

  public Integer getMaxWorkerId() {
    return employeeMapper.getMaxWorkerId();
  }
}


