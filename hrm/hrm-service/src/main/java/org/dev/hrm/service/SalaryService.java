package org.dev.hrm.service;

import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.SalaryMapper;
import org.dev.hrm.model.Salary;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName SalaryService.java

 * @createTime 2020年03月29日 15:17:00
 */
@Service
public class SalaryService {

  @Resource
  private SalaryMapper salaryMapper;


  public int deleteByPrimaryKey(Integer id) {
    return salaryMapper.deleteByPrimaryKey(id);
  }


  public int insert(Salary record) {
    return salaryMapper.insert(record);
  }


  public int insertSelective(Salary record) {
    return salaryMapper.insertSelective(record);
  }


  public Salary selectByPrimaryKey(Integer id) {
    return salaryMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(Salary record) {
    return salaryMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(Salary record) {
    return salaryMapper.updateByPrimaryKey(record);
  }

  public List<Salary> getAllSalaries() {
    return salaryMapper.getAllSalaries();
  }

//  public RespPageBean getDepsSalaryTable(Integer page, Integer size, Integer depId) {
//    if (page != null && size != null) {
//      page = (page - 1) * size;
//    }
//    List<Employee> list = salaryMapper.getDepsSalaryTable(page, size, depId);
//    RespPageBean respPageBean = new RespPageBean();
//    respPageBean.setData(list);
//    respPageBean.setTotal(salaryMapper.getTotal(null, null));
//    return respPageBean;
//  }
}
