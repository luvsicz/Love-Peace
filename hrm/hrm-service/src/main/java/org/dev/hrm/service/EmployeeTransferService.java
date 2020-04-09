package org.dev.hrm.service;

import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.EmployeeTransferMapper;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.EmployeeTransfer;
import org.dev.hrm.model.RespPageBean;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmployeeTransferService.java
 * @createTime 2020年04月08日 13:27:00
 */
@Service
public class EmployeeTransferService {

  @Resource
  private EmployeeTransferMapper employeeTransferMapper;


  public int deleteByPrimaryKey(Integer id) {
    return employeeTransferMapper.deleteByPrimaryKey(id);
  }


  public int insert(EmployeeTransfer record) {
    return employeeTransferMapper.insert(record);
  }


  public int insertSelective(EmployeeTransfer record) {
    return employeeTransferMapper.insertSelective(record);
  }


  public EmployeeTransfer selectByPrimaryKey(Integer id) {
    return employeeTransferMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(EmployeeTransfer record) {
    return employeeTransferMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(EmployeeTransfer record) {
    return employeeTransferMapper.updateByPrimaryKey(record);
  }

  public RespPageBean getEmployeeTransInfoByPage(Integer page, Integer size,
      Employee emp) {
    if (page != null && size != null) {
      page = (page - 1) * size;
    }
    List<EmployeeTransfer> data = employeeTransferMapper
        .getEmployeeTransInfoByPage(page, size, emp);
    long total = employeeTransferMapper.getTotal(emp);
    RespPageBean pageBean = new RespPageBean();
    pageBean.setTotal(total);
    pageBean.setData(data);
    return pageBean;
  }

  public int deleteByPrimaryKeys(String ids) {
    String[] id = ids.split(",");
    return employeeTransferMapper.deleteByPrimaryKeys(id);
  }

  public void commit(EmployeeTransfer employeeTransfer) {
    employeeTransferMapper.commit(employeeTransfer);

  }
}
