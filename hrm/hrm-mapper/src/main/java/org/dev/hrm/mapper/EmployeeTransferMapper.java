package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.EmployeeTransfer;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmployeeTransferMapper.java
 * @createTime 2020年04月08日 13:27:00
 */
@Mapper
public interface EmployeeTransferMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(EmployeeTransfer record);

  int insertSelective(EmployeeTransfer record);

  EmployeeTransfer selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(EmployeeTransfer record);

  int updateByPrimaryKey(EmployeeTransfer record);

  List<EmployeeTransfer> getEmployeeTransInfoByPage(@Param("page") Integer page,
      @Param("size") Integer size,
      @Param("emp") Employee emp
  );

  long getTotal(@Param("emp") Employee emp);

  int deleteByPrimaryKeys(@Param("ids") String[] id);
}