package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.model.Employeeremove;
import java.util.List;
import org.dev.hrm.model.EmployeeremoveExample;
import org.dev.hrm.mapper.EmployeeremoveMapper;
/**
 * @ClassName EmployeeremoveService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class EmployeeremoveService{

    @Resource
    private EmployeeremoveMapper employeeremoveMapper;

    
    public long countByExample(EmployeeremoveExample example) {
        return employeeremoveMapper.countByExample(example);
    }

    
    public int deleteByExample(EmployeeremoveExample example) {
        return employeeremoveMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return employeeremoveMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Employeeremove record) {
        return employeeremoveMapper.insert(record);
    }

    
    public int insertSelective(Employeeremove record) {
        return employeeremoveMapper.insertSelective(record);
    }

    
    public List<Employeeremove> selectByExample(EmployeeremoveExample example) {
        return employeeremoveMapper.selectByExample(example);
    }

    
    public Employeeremove selectByPrimaryKey(Integer id) {
        return employeeremoveMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(Employeeremove record,EmployeeremoveExample example) {
        return employeeremoveMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Employeeremove record,EmployeeremoveExample example) {
        return employeeremoveMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Employeeremove record) {
        return employeeremoveMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Employeeremove record) {
        return employeeremoveMapper.updateByPrimaryKey(record);
    }

}
