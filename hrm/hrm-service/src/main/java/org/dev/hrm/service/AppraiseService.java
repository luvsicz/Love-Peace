package org.dev.hrm.service;

import javax.annotation.Resource;
import org.dev.hrm.mapper.AppraiseMapper;
import org.dev.hrm.model.Appraise;
import org.springframework.stereotype.Service;
/**
 * @ClassName AppraiseService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 20:15:00
 */
@Service
public class AppraiseService{

    @Resource
    private AppraiseMapper appraiseMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return appraiseMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Appraise record) {
        return appraiseMapper.insert(record);
    }

    
    public int insertSelective(Appraise record) {
        return appraiseMapper.insertSelective(record);
    }

    
    public Appraise selectByPrimaryKey(Integer id) {
        return appraiseMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Appraise record) {
        return appraiseMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Appraise record) {
        return appraiseMapper.updateByPrimaryKey(record);
    }

}
