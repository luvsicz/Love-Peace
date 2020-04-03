package org.dev.hrm.service;

import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.SysmsgMapper;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.RespPageBean;
import org.dev.hrm.model.Sysmsg;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName SysmsgService.java
 * @createTime 2020年04月01日 15:20:00
 */
@Service
public class SysmsgService {

  @Resource
  private SysmsgMapper sysmsgMapper;


  public int deleteByPrimaryKey(Integer id) {
    return sysmsgMapper.deleteByPrimaryKey(id);
  }


  public int insert(Sysmsg record) {
    return sysmsgMapper.insert(record);
  }


  public int insertSelective(Sysmsg record) {
    return sysmsgMapper.insertSelective(record);
  }


  public Sysmsg selectByPrimaryKey(Integer id) {
    return sysmsgMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(Sysmsg record) {
    return sysmsgMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(Sysmsg record) {
    return sysmsgMapper.updateByPrimaryKey(record);
  }

  public RespPageBean getMyNotices(Integer page, Integer size) {
    if (page != null && size != null) {
      page = (page - 1) * size;
    }
    Hr currentHr = ((Hr) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal());

    List<Sysmsg> data = sysmsgMapper
        .getAllNotices(page, size, currentHr.getId());
    long total = sysmsgMapper.getTotal(currentHr.getId());
    RespPageBean pageBean = new RespPageBean();
    pageBean.setTotal(total);
    pageBean.setData(data);
    return pageBean;
  }

//  public RespPageBean getAllNotices(Integer page, Integer size) {
//    if (page != null && size != null) {
//      page = (page - 1) * size;
//    }
//    List<Sysmsg> data = sysmsgMapper
//        .getAllNotices(page, size, null);
//    long total = sysmsgMapper.getTotal(null);
//    RespPageBean pageBean = new RespPageBean();
//    pageBean.setTotal(total);
//    pageBean.setData(data);
//    return pageBean;
//  }

  public boolean deleteMyNotifications(Integer mid) {
    Hr currentHr = ((Hr) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal());
    return sysmsgMapper.deleteMyNotifications(mid, currentHr.getId()) == 1;
  }

  public boolean updateByPrimaryKeysSelective(String ids) {
    String[] id = ids.split(",");
    Hr currentHr = ((Hr) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal());
    return sysmsgMapper.updateByPrimaryKeysSelective(id, currentHr.getId()) > 1;
  }
}
