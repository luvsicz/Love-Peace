package org.dev.hrm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dev.hrm.model.Adjustsalary;

/**
 * @ClassName AdjustsalaryMapper.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 20:14:00
 */
@Mapper
public interface AdjustsalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Adjustsalary record);

    int insertSelective(Adjustsalary record);

    Adjustsalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Adjustsalary record);

    int updateByPrimaryKey(Adjustsalary record);
}