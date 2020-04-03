package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.mapper.EmployeetrainMapper;
import org.dev.hrm.model.Employeetrain;
/**
 * @ClassName EmployeetrainService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 20:15:00
 */
@Service
public class EmployeetrainService{

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

}
