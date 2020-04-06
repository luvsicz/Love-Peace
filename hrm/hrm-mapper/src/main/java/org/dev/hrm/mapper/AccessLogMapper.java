package org.dev.hrm.mapper;

import java.util.Date;import java.util.List;import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;import org.dev.hrm.model.AccessLog;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName AccessLogMapper.java
 * @createTime 2020年04月06日 15:49:00
 */
@Mapper
public interface AccessLogMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(AccessLog record);

  int insertSelective(AccessLog record);

  AccessLog selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(AccessLog record);

  int updateByPrimaryKey(AccessLog record);

  List<AccessLog> getAccessLogByPage(@Param("page") Integer page,
      @Param("size") Integer size,
      @Param("accessLog") AccessLog accessLog,
      @Param("beginDateScope") Date[] beginDateScope);

  long getTotal(@Param("accessLog") AccessLog accessLog,
      @Param("beginDateScope") Date[] beginDateScope);

  int truncateAll();
}