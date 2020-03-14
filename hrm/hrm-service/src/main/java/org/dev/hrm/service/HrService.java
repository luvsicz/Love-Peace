package org.dev.hrm.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.dev.hrm.mapper.HrMapper;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.HrExample;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName HrService.java
 * @Description HrService
 * @createTime 2019年12月29日 22:03:00
 */
@Service
@AllArgsConstructor
public class HrService {

  private HrMapper hrMapper;


  public long countByExample(HrExample example) {
    return hrMapper.countByExample(example);
  }


  public int deleteByExample(HrExample example) {
    return hrMapper.deleteByExample(example);
  }


  public int deleteByPrimaryKey(Integer id) {
    return hrMapper.deleteByPrimaryKey(id);
  }


  public int insert(Hr record) {
    return hrMapper.insert(record);
  }


  public int insertSelective(Hr record) {
    return hrMapper.insertSelective(record);
  }


  public List<Hr> selectByExample(HrExample example) {
    return hrMapper.selectByExample(example);
  }


  public Hr selectByPrimaryKey(Integer id) {
    return hrMapper.selectByPrimaryKey(id);
  }


  public int updateByExampleSelective(Hr record, HrExample example) {
    return hrMapper.updateByExampleSelective(record, example);
  }


  public int updateByExample(Hr record, HrExample example) {
    return hrMapper.updateByExample(record, example);
  }


  public int updateByPrimaryKeySelective(Hr record) {
    return hrMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(Hr record) {
    return hrMapper.updateByPrimaryKey(record);
  }

}
