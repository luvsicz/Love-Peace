package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.MsgContent;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName MsgContentMapper.java
 * @createTime 2020年04月01日 15:21:00
 */
@Mapper
public interface MsgContentMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(MsgContent record);

  int insertSelective(MsgContent record);

  MsgContent selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(MsgContent record);

  int updateByPrimaryKey(MsgContent record);

  long getTotal(@Param("hrId") Integer hrId);

  List<MsgContent> getAllMsg(
      @Param("page") Integer page, @Param("size") Integer size,
      @Param("hrId") Integer hrId);

  List<MsgContent> getAllNotices(
      @Param("page") Integer page, @Param("size") Integer size);

  long getNoticesNum();
}