package org.dev.hrm.service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.PositionMapper;
import org.dev.hrm.model.Position;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName PositionService.java
 * @createTime 2020年03月24日 16:00:00
 */
@Service
public class PositionService {

  @Resource
  PositionMapper positionMapper;

  public int deleteByPrimaryKey(Integer id) {
    return positionMapper.deleteByPrimaryKey(id);
  }

  public int insert(Position record) {
    return positionMapper.insert(record);
  }

  public int insertSelective(Position record) {
    return positionMapper.insertSelective(record);
  }

  public Position selectByPrimaryKey(Integer id) {
    return positionMapper.selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(Position record) {
    return positionMapper.updateByPrimaryKeySelective(record);
  }

  public int updateByPrimaryKey(Position record) {
    return positionMapper.updateByPrimaryKey(record);
  }

  public List<Position> getAllPositions() {
    return positionMapper.getAllPositions();
  }

  public Integer addPosition(Position position) {
    position.setEnabled(true);
    position.setCreateDate(new Date());
    return positionMapper.insertSelective(position);
  }

  public Integer deleteByPrimaryKeys(Integer[] ids) {
    return positionMapper.deletePositionsByIds(ids);
  }
}

