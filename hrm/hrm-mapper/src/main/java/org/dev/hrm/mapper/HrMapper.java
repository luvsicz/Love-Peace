package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.HrExample;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName HrMapper.java
 * @Description HrMapper
 * @createTime 2019年12月29日 22:03:00
 */
@Mapper
public interface HrMapper {

  long countByExample(HrExample example);

  int deleteByExample(HrExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(Hr record);

  int insertSelective(Hr record);

  List<Hr> selectByExample(HrExample example);

  Hr selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") Hr record, @Param("example") HrExample example);

  int updateByExample(@Param("record") Hr record, @Param("example") HrExample example);

  int updateByPrimaryKeySelective(Hr record);

  int updateByPrimaryKey(Hr record);
}