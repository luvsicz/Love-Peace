package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import org.dev.hrm.mapper.SysmsgMapper;
import org.dev.hrm.model.Sysmsg;
import org.dev.hrm.model.SysmsgExample;
/**
 * @ClassName SysmsgService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class SysmsgService{

    @Resource
    private SysmsgMapper sysmsgMapper;

    
    public long countByExample(SysmsgExample example) {
        return sysmsgMapper.countByExample(example);
    }

    
    public int deleteByExample(SysmsgExample example) {
        return sysmsgMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return sysmsgMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Sysmsg record) {
        return sysmsgMapper.insert(record);
    }

    
    public int insertSelective(Sysmsg record) {
        return sysmsgMapper.insertSelective(record);
    }

    
    public List<Sysmsg> selectByExample(SysmsgExample example) {
        return sysmsgMapper.selectByExample(example);
    }

    
    public Sysmsg selectByPrimaryKey(Integer id) {
        return sysmsgMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(Sysmsg record,SysmsgExample example) {
        return sysmsgMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Sysmsg record,SysmsgExample example) {
        return sysmsgMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Sysmsg record) {
        return sysmsgMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Sysmsg record) {
        return sysmsgMapper.updateByPrimaryKey(record);
    }

}
