package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.model.Adjustsalary;
import org.dev.hrm.mapper.AdjustsalaryMapper;
/**
 * @ClassName AdjustsalaryService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 20:14:00
 */
@Service
public class AdjustsalaryService{

    @Resource
    private AdjustsalaryMapper adjustsalaryMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return adjustsalaryMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Adjustsalary record) {
        return adjustsalaryMapper.insert(record);
    }

    
    public int insertSelective(Adjustsalary record) {
        return adjustsalaryMapper.insertSelective(record);
    }

    
    public Adjustsalary selectByPrimaryKey(Integer id) {
        return adjustsalaryMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Adjustsalary record) {
        return adjustsalaryMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Adjustsalary record) {
        return adjustsalaryMapper.updateByPrimaryKey(record);
    }

}
