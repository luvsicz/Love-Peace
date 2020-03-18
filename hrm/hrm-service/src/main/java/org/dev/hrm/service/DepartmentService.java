package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.model.DepartmentExample;
import org.dev.hrm.mapper.DepartmentMapper;
import java.util.List;
import org.dev.hrm.model.Department;
/**
 * @ClassName DepartmentService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class DepartmentService{

    @Resource
    private DepartmentMapper departmentMapper;

    
    public long countByExample(DepartmentExample example) {
        return departmentMapper.countByExample(example);
    }

    
    public int deleteByExample(DepartmentExample example) {
        return departmentMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    
    public List<Department> selectByExample(DepartmentExample example) {
        return departmentMapper.selectByExample(example);
    }

    
    public Department selectByPrimaryKey(Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(Department record,DepartmentExample example) {
        return departmentMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Department record,DepartmentExample example) {
        return departmentMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

}
