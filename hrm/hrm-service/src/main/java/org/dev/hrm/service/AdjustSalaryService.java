package org.dev.hrm.service;

import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.AdjustSalaryMapper;
import org.dev.hrm.model.AdjustSalary;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.RespPageBean;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName AdjustSalaryService.java
 * @createTime 2020年04月02日 20:14:00
 */
@Service
public class AdjustSalaryService {

  @Resource
  private AdjustSalaryMapper adjustsalaryMapper;


  public int deleteByPrimaryKey(Integer id) {
    return adjustsalaryMapper.deleteByPrimaryKey(id);
  }


  public int insert(AdjustSalary record) {
    return adjustsalaryMapper.insert(record);
  }


  public int insertSelective(AdjustSalary record) {
    return adjustsalaryMapper.insertSelective(record);
  }


  public AdjustSalary selectByPrimaryKey(Integer id) {
    return adjustsalaryMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(AdjustSalary record) {
    return adjustsalaryMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(AdjustSalary record) {
    return adjustsalaryMapper.updateByPrimaryKey(record);
  }

  public RespPageBean getAdjustSalaryByPage(Integer page, Integer size,
      Employee emp) {
    if (page != null && size != null) {
      page = (page - 1) * size;
    }
    List<AdjustSalary> data = adjustsalaryMapper
        .getAdjustSalaryByPage(page, size, emp);
    long total = adjustsalaryMapper.getTotal(emp);
    RespPageBean pageBean = new RespPageBean();
    pageBean.setTotal(total);
    pageBean.setData(data);
    return pageBean;
  }

  public int deleteByPrimaryKeys(String ids) {
    String[] id = ids.split(",");
    return adjustsalaryMapper.deleteByPrimaryKeys(id);
  }
}
