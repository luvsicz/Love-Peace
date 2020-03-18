package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.mapper.EmployeetrainMapper;
import java.util.List;
import org.dev.hrm.model.Employeetrain;
import org.dev.hrm.model.EmployeetrainExample;
/**
 * @ClassName EmployeetrainService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class EmployeetrainService{

    @Resource
    private EmployeetrainMapper employeetrainMapper;

    
    public long countByExample(EmployeetrainExample example) {
        return employeetrainMapper.countByExample(example);
    }

    
    public int deleteByExample(EmployeetrainExample example) {
        return employeetrainMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return employeetrainMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Employeetrain record) {
        return employeetrainMapper.insert(record);
    }

    
    public int insertSelective(Employeetrain record) {
        return employeetrainMapper.insertSelective(record);
    }

    
    public List<Employeetrain> selectByExample(EmployeetrainExample example) {
        return employeetrainMapper.selectByExample(example);
    }

    
    public Employeetrain selectByPrimaryKey(Integer id) {
        return employeetrainMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(Employeetrain record,EmployeetrainExample example) {
        return employeetrainMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Employeetrain record,EmployeetrainExample example) {
        return employeetrainMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Employeetrain record) {
        return employeetrainMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Employeetrain record) {
        return employeetrainMapper.updateByPrimaryKey(record);
    }

}
