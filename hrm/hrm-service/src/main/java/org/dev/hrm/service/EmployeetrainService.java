package org.dev.hrm.service;

import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.EmployeetrainMapper;
import org.dev.hrm.model.Employeetrain;
import org.dev.hrm.model.RespPageBean;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmployeetrainService.java
 * @createTime 2020年04月02日 20:15:00
 */
@Service
public class EmployeetrainService {

  @Resource
  private EmployeetrainMapper employeetrainMapper;


  public int deleteByPrimaryKey(Integer id) {
    return employeetrainMapper.deleteByPrimaryKey(id);
  }


  public int insert(Employeetrain record) {
    return employeetrainMapper.insert(record);
  }


  public int insertSelective(Employeetrain record) {
    return employeetrainMapper.insertSelective(record);
  }


  public Employeetrain selectByPrimaryKey(Integer id) {
    return employeetrainMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(Employeetrain record) {
    return employeetrainMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(Employeetrain record) {
    return employeetrainMapper.updateByPrimaryKey(record);
  }

  public RespPageBean getTrainingInfoByPage(Integer page, Integer size) {
    if (page != null && size != null) {
      page = (page - 1) * size;
    }
    List<Employeetrain> data = employeetrainMapper
        .selectByPage(page, size);
    long total = employeetrainMapper.getTotal();
    RespPageBean pageBean = new RespPageBean();
    pageBean.setTotal(total);
    pageBean.setData(data);
    return pageBean;
  }
}


