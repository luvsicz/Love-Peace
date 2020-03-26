package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.dev.hrm.model.Department;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName DepartmentMapper.java
 * @Description TODO
 * @createTime 2020年03月23日 19:57:00
 */
@Mapper
public interface DepartmentMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(Department record);

  int insertSelective(Department record);

  Department selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Department record);

  int updateByPrimaryKey(Department record);

  List<Department> getAllDepartments();

  void addDepartment(Department dep);

  void delDepartment(Department dep);

  List<Department> getAllDepartmentsByParentId(Integer index);
}