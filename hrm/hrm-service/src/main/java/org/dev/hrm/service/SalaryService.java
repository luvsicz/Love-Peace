package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.mapper.SalaryMapper;
import java.util.List;
import org.dev.hrm.model.Salary;
import org.dev.hrm.model.SalaryExample;
/**
 * @ClassName SalaryService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class SalaryService{

    @Resource
    private SalaryMapper salaryMapper;

    
    public long countByExample(SalaryExample example) {
        return salaryMapper.countByExample(example);
    }

    
    public int deleteByExample(SalaryExample example) {
        return salaryMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Salary record) {
        return salaryMapper.insert(record);
    }

    
    public int insertSelective(Salary record) {
        return salaryMapper.insertSelective(record);
    }

    
    public List<Salary> selectByExample(SalaryExample example) {
        return salaryMapper.selectByExample(example);
    }

    
    public Salary selectByPrimaryKey(Integer id) {
        return salaryMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(Salary record,SalaryExample example) {
        return salaryMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Salary record,SalaryExample example) {
        return salaryMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Salary record) {
        return salaryMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Salary record) {
        return salaryMapper.updateByPrimaryKey(record);
    }

}
