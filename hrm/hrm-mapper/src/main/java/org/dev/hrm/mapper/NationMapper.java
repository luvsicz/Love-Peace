package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.dev.hrm.model.Nation;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName NationMapper.java
 * @createTime 2020年03月18日 15:49:00
 */
@Mapper
public interface NationMapper {


  int deleteByPrimaryKey(Integer id);

  int insert(Nation record);

  int insertSelective(Nation record);


  Nation selectByPrimaryKey(Integer id);


  int updateByPrimaryKeySelective(Nation record);

  int updateByPrimaryKey(Nation record);

  List<Nation> selectAllNations();
}