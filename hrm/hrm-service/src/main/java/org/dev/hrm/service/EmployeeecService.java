package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.model.Employeeec;
import org.dev.hrm.mapper.EmployeeecMapper;
/**
 * @ClassName EmployeeecService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 19:59:00
 */
@Service
public class EmployeeecService{

    @Resource
    private EmployeeecMapper employeeecMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return employeeecMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Employeeec record) {
        return employeeecMapper.insert(record);
    }

    
    public int insertSelective(Employeeec record) {
        return employeeecMapper.insertSelective(record);
    }

    
    public Employeeec selectByPrimaryKey(Integer id) {
        return employeeecMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Employeeec record) {
        return employeeecMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Employeeec record) {
        return employeeecMapper.updateByPrimaryKey(record);
    }

}
