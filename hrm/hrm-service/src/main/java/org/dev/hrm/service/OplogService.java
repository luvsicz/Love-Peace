package org.dev.hrm.service;

import java.util.List;
import org.dev.hrm.model.AccessLog;
import org.dev.hrm.model.RespPageBean;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.dev.hrm.model.Oplog;
import org.dev.hrm.mapper.OplogMapper;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName OplogService.java
 * @createTime 2020年04月06日 14:13:00
 */
@Service
public class OplogService {

  @Resource
  private OplogMapper oplogMapper;


  public int deleteByPrimaryKey(Integer id) {
    return oplogMapper.deleteByPrimaryKey(id);
  }


  public int insert(Oplog record) {
    return oplogMapper.insert(record);
  }


  public int insertSelective(Oplog record) {
    return oplogMapper.insertSelective(record);
  }


  public Oplog selectByPrimaryKey(Integer id) {
    return oplogMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(Oplog record) {
    return oplogMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(Oplog record) {
    return oplogMapper.updateByPrimaryKey(record);
  }

  public RespPageBean getOpLogByPage(Integer page, Integer size, Oplog oplog) {
    if (page != null && size != null) {
      page = (page - 1) * size;
    }
    List<Oplog> data = oplogMapper
        .getOpLogByPage(page, size, oplog);
    long total = oplogMapper.getTotal(oplog);
    RespPageBean pageBean = new RespPageBean();
    pageBean.setTotal(total);
    pageBean.setData(data);
    return pageBean;
  }

  public Integer deleteAll() {
    return oplogMapper.deleteAll();
  }
}

