package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import org.dev.hrm.model.NationExample;
import org.dev.hrm.mapper.NationMapper;
import org.dev.hrm.model.Nation;
/**
 * @ClassName NationService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class NationService{

    @Resource
    private NationMapper nationMapper;

    
    public long countByExample(NationExample example) {
        return nationMapper.countByExample(example);
    }

    
    public int deleteByExample(NationExample example) {
        return nationMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return nationMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Nation record) {
        return nationMapper.insert(record);
    }

    
    public int insertSelective(Nation record) {
        return nationMapper.insertSelective(record);
    }

    
    public List<Nation> selectByExample(NationExample example) {
        return nationMapper.selectByExample(example);
    }

    
    public Nation selectByPrimaryKey(Integer id) {
        return nationMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(Nation record,NationExample example) {
        return nationMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Nation record,NationExample example) {
        return nationMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Nation record) {
        return nationMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Nation record) {
        return nationMapper.updateByPrimaryKey(record);
    }

}
