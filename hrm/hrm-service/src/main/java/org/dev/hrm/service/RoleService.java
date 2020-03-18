package org.dev.hrm.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.mapper.RoleMapper;
import java.util.List;
import org.dev.hrm.model.RoleExample;
import org.dev.hrm.model.Role;
/**
 * @ClassName RoleService.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Service
public class RoleService{

    @Resource
    private RoleMapper roleMapper;

    
    public long countByExample(RoleExample example) {
        return roleMapper.countByExample(example);
    }

    
    public int deleteByExample(RoleExample example) {
        return roleMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    
    public List<Role> selectByExample(RoleExample example) {
        return roleMapper.selectByExample(example);
    }

    
    public Role selectByPrimaryKey(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(Role record,RoleExample example) {
        return roleMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Role record,RoleExample example) {
        return roleMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

}
