package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.EmployeeRemove;
import org.dev.hrm.model.Employeetrain;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmployeetrainMapper.java
 * @createTime 2020年04月04日 15:47:00
 */
@Mapper
public interface EmployeetrainMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(Employeetrain record);

  int insertSelective(Employeetrain record);

  Employeetrain selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Employeetrain record);

  int updateByPrimaryKey(Employeetrain record);

  long getTotal();

  List<Employeetrain > selectByPage(
      @Param("page") Integer page, @Param("size") Integer size);
}