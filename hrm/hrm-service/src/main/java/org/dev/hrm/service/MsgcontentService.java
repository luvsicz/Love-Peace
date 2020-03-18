package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.model.Msgcontent;
import java.util.List;
import org.dev.hrm.model.MsgcontentExample;
import org.dev.hrm.mapper.MsgcontentMapper;
/**
 * @ClassName MsgcontentService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class MsgcontentService{

    @Resource
    private MsgcontentMapper msgcontentMapper;

    
    public long countByExample(MsgcontentExample example) {
        return msgcontentMapper.countByExample(example);
    }

    
    public int deleteByExample(MsgcontentExample example) {
        return msgcontentMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return msgcontentMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Msgcontent record) {
        return msgcontentMapper.insert(record);
    }

    
    public int insertSelective(Msgcontent record) {
        return msgcontentMapper.insertSelective(record);
    }

    
    public List<Msgcontent> selectByExample(MsgcontentExample example) {
        return msgcontentMapper.selectByExample(example);
    }

    
    public Msgcontent selectByPrimaryKey(Integer id) {
        return msgcontentMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(Msgcontent record,MsgcontentExample example) {
        return msgcontentMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Msgcontent record,MsgcontentExample example) {
        return msgcontentMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Msgcontent record) {
        return msgcontentMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Msgcontent record) {
        return msgcontentMapper.updateByPrimaryKey(record);
    }

}
