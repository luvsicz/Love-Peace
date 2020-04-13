package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.AdjustSalary;
import org.dev.hrm.model.Employee;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName AdjustSalaryMapper.java
 * @createTime 2020年04月09日 15:32:00
 */
@Mapper
public interface AdjustSalaryMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(AdjustSalary record);

  int insertSelective(AdjustSalary record);

  AdjustSalary selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(AdjustSalary record);

  int updateByPrimaryKey(AdjustSalary record);

  List<AdjustSalary> getAdjustSalaryByPage(
      @Param("page") Integer page, @Param("size") Integer size,
      @Param("emp") Employee emp);

  long getTotal(@Param("emp") Employee emp);

  int deleteByPrimaryKeys(@Param("ids") String[] ids);

}