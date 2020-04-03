package org.dev.hrm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dev.hrm.model.EmployeeRemove;

/**
 * @ClassName EmployeeRemoveMapper.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 20:16:00
 */
@Mapper
public interface EmployeeRemoveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeRemove record);

    int insertSelective(EmployeeRemove record);

    EmployeeRemove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeRemove record);

    int updateByPrimaryKey(EmployeeRemove record);
}