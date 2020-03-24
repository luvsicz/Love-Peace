package org.dev.hrm.service;

import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.PoliticsStatusMapper;
import org.dev.hrm.model.PoliticsStatus;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName PoliticsStatusService.java
 * @Description TODO
 * @createTime 2020年03月24日 15:48:00
 */
@Service
public class PoliticsStatusService {

  @Resource
  PoliticsStatusMapper politicsStatusMapper;

  public int deleteByPrimaryKey(Integer id) {
    return politicsStatusMapper.deleteByPrimaryKey(id);
  }

  public int insert(PoliticsStatus record) {
    return politicsStatusMapper.insert(record);
  }

  public int insertSelective(PoliticsStatus record) {
    return politicsStatusMapper.insertSelective(record);
  }

  public PoliticsStatus selectByPrimaryKey(Integer id) {
    return politicsStatusMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(PoliticsStatus record) {
    return politicsStatusMapper.updateByPrimaryKeySelective(record);
  }

  public int updateByPrimaryKey(PoliticsStatus record) {
    return politicsStatusMapper.updateByPrimaryKey(record);
  }

  public List<PoliticsStatus> getAllPoliticsStatus() {
    return politicsStatusMapper.getAllPoliticsStatus();
  }

}

