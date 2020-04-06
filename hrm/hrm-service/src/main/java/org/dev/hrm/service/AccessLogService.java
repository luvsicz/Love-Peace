package org.dev.hrm.service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.AccessLogMapper;
import org.dev.hrm.model.AccessLog;
import org.dev.hrm.model.RespPageBean;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName AccessLogService.java
 * @createTime 2020年03月30日 21:33:00
 */
@Service
public class AccessLogService {

  @Resource
  private AccessLogMapper accessLogMapper;


  public int deleteByPrimaryKey(Integer id) {
    return accessLogMapper.deleteByPrimaryKey(id);
  }


  public int insert(AccessLog record) {
    return accessLogMapper.insert(record);
  }


  public int insertSelective(AccessLog record) {
    return accessLogMapper.insertSelective(record);
  }


  public AccessLog selectByPrimaryKey(Integer id) {
    return accessLogMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(AccessLog record) {
    return accessLogMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(AccessLog record) {
    return accessLogMapper.updateByPrimaryKey(record);
  }

  public RespPageBean getAccessLogByPage(Integer page, Integer size,
      AccessLog accessLog,
      Date[] beginDateScope) {
    if (page != null && size != null) {
      page = (page - 1) * size;
    }
    List<AccessLog> data = accessLogMapper
        .getAccessLogByPage(page, size, accessLog,
            beginDateScope);
    long total = accessLogMapper.getTotal(accessLog, beginDateScope);
    RespPageBean pageBean = new RespPageBean();
    pageBean.setTotal(total);
    pageBean.setData(data);
    return pageBean;
  }

  public int truncateAll() {
    return accessLogMapper.truncateAll();
  }
}

