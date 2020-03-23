package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.mapper.DepartmentMapper;
import org.dev.hrm.model.Department;
/**
 * @ClassName DepartmentService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月23日 19:57:00
 */
@Service
public class DepartmentService{

    @Resource
    private DepartmentMapper departmentMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    
    public Department selectByPrimaryKey(Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

}
