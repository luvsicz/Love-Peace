package org.dev.hrm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dev.hrm.model.Position;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName PositionMapper.java
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Mapper
public interface PositionMapper {


  int deleteByPrimaryKey(Integer id);

  int insert(Position record);

  int insertSelective(Position record);


  Position selectByPrimaryKey(Integer id);


  int updateByPrimaryKeySelective(Position record);

  int updateByPrimaryKey(Position record);
}