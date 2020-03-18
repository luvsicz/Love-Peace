package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.model.AdjustsalaryExample;
import java.util.List;
import org.dev.hrm.model.Adjustsalary;
import org.dev.hrm.mapper.AdjustsalaryMapper;
/**
 * @ClassName AdjustsalaryService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class AdjustsalaryService{

    @Resource
    private AdjustsalaryMapper adjustsalaryMapper;

    
    public long countByExample(AdjustsalaryExample example) {
        return adjustsalaryMapper.countByExample(example);
    }

    
    public int deleteByExample(AdjustsalaryExample example) {
        return adjustsalaryMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return adjustsalaryMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Adjustsalary record) {
        return adjustsalaryMapper.insert(record);
    }

    
    public int insertSelective(Adjustsalary record) {
        return adjustsalaryMapper.insertSelective(record);
    }

    
    public List<Adjustsalary> selectByExample(AdjustsalaryExample example) {
        return adjustsalaryMapper.selectByExample(example);
    }

    
    public Adjustsalary selectByPrimaryKey(Integer id) {
        return adjustsalaryMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(Adjustsalary record,AdjustsalaryExample example) {
        return adjustsalaryMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Adjustsalary record,AdjustsalaryExample example) {
        return adjustsalaryMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Adjustsalary record) {
        return adjustsalaryMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Adjustsalary record) {
        return adjustsalaryMapper.updateByPrimaryKey(record);
    }

}
