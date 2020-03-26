package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.Position;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName PositionMapper.java
 * @Description TODO
 * @createTime 2020年03月24日 16:01:00
 */
@Mapper
public interface PositionMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(Position record);

  int insertSelective(Position record);

  Position selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Position record);

  int updateByPrimaryKey(Position record);

  List<Position> getAllPositions();

  Integer deletePositionsByIds(@Param("ids") Integer[] ids);
}