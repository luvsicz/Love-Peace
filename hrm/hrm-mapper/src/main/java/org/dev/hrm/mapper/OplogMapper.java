package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.AccessLog;
import org.dev.hrm.model.Oplog;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName OplogMapper.java
 * @createTime 2020年04月06日 14:36:00
 */
@Mapper
public interface OplogMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(Oplog record);

  int insertSelective(Oplog record);

  Oplog selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Oplog record);

  int updateByPrimaryKey(Oplog record);

  long getTotal(@Param("oplog") Oplog oplog);

  List<Oplog> getOpLogByPage(
      @Param("page") Integer page, @Param("size") Integer size,
      @Param("oplog") Oplog oplog);

  Integer deleteAll();
}