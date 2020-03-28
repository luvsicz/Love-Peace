package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.JobLevel;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName JobLevelMapper.java
 * @createTime 2020年03月24日 15:56:00
 */
@Mapper
public interface JobLevelMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(JobLevel record);

  int insertSelective(JobLevel record);

  JobLevel selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(JobLevel record);

  int updateByPrimaryKey(JobLevel record);

  List<JobLevel> getAllJobLevels();

  Integer deleteByPrimaryKeys(@Param("ids") Integer[] ids);
}