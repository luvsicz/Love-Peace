package org.dev.hrm.service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.JobLevelMapper;
import org.dev.hrm.model.JobLevel;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName JobLevelService.java
 * @Description TODO
 * @createTime 2020年03月24日 15:56:00
 */
@Service
public class JobLevelService {

  @Resource
  private JobLevelMapper jobLevelMapper;


  public int deleteByPrimaryKey(Integer id) {
    return jobLevelMapper.deleteByPrimaryKey(id);
  }


  public int insert(JobLevel record) {
    return jobLevelMapper.insert(record);
  }


  public int insertSelective(JobLevel record) {
    record.setCreateDate(new Date());
    record.setEnabled(true);
    return jobLevelMapper.insertSelective(record);
  }


  public JobLevel selectByPrimaryKey(Integer id) {
    return jobLevelMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(JobLevel record) {
    return jobLevelMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(JobLevel record) {
    return jobLevelMapper.updateByPrimaryKey(record);
  }

  public List<JobLevel> getAllJobLevels() {
    return jobLevelMapper.getAllJobLevels();
  }

  public Integer deleteByPrimaryKeys(Integer[] ids) {
    return jobLevelMapper.deleteByPrimaryKeys(ids);
  }
}
