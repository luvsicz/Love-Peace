package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.model.Oplog;
import java.util.List;
import org.dev.hrm.model.OplogExample;
import org.dev.hrm.mapper.OplogMapper;
/**
 * @ClassName OplogService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class OplogService{

    @Resource
    private OplogMapper oplogMapper;

    
    public long countByExample(OplogExample example) {
        return oplogMapper.countByExample(example);
    }

    
    public int deleteByExample(OplogExample example) {
        return oplogMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return oplogMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Oplog record) {
        return oplogMapper.insert(record);
    }

    
    public int insertSelective(Oplog record) {
        return oplogMapper.insertSelective(record);
    }

    
    public List<Oplog> selectByExample(OplogExample example) {
        return oplogMapper.selectByExample(example);
    }

    
    public Oplog selectByPrimaryKey(Integer id) {
        return oplogMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(Oplog record,OplogExample example) {
        return oplogMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Oplog record,OplogExample example) {
        return oplogMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Oplog record) {
        return oplogMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Oplog record) {
        return oplogMapper.updateByPrimaryKey(record);
    }

}
