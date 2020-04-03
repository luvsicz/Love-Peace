package org.dev.hrm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dev.hrm.model.Employeetrain;

/**
 * @ClassName EmployeetrainMapper.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 20:15:00
 */
@Mapper
public interface EmployeetrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeetrain record);

    int insertSelective(Employeetrain record);

    Employeetrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeetrain record);

    int updateByPrimaryKey(Employeetrain record);
}