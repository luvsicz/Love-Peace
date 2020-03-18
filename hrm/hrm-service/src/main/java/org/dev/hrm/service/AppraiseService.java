package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import org.dev.hrm.mapper.AppraiseMapper;
import org.dev.hrm.model.Appraise;
import org.dev.hrm.model.AppraiseExample;
/**
 * @ClassName AppraiseService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class AppraiseService{

    @Resource
    private AppraiseMapper appraiseMapper;

    
    public long countByExample(AppraiseExample example) {
        return appraiseMapper.countByExample(example);
    }

    
    public int deleteByExample(AppraiseExample example) {
        return appraiseMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return appraiseMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Appraise record) {
        return appraiseMapper.insert(record);
    }

    
    public int insertSelective(Appraise record) {
        return appraiseMapper.insertSelective(record);
    }

    
    public List<Appraise> selectByExample(AppraiseExample example) {
        return appraiseMapper.selectByExample(example);
    }

    
    public Appraise selectByPrimaryKey(Integer id) {
        return appraiseMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(Appraise record,AppraiseExample example) {
        return appraiseMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Appraise record,AppraiseExample example) {
        return appraiseMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Appraise record) {
        return appraiseMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Appraise record) {
        return appraiseMapper.updateByPrimaryKey(record);
    }

}
