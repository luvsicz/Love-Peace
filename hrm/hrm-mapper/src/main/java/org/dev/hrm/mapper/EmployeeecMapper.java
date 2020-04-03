package org.dev.hrm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dev.hrm.model.Employeeec;

/**
 * @ClassName EmployeeecMapper.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 19:59:00
 */
@Mapper
public interface EmployeeecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);
}