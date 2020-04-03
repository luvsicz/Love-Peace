package org.dev.hrm.service;

import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.HrMapper;
import org.dev.hrm.mapper.MsgContentMapper;
import org.dev.hrm.mapper.SysmsgMapper;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.MsgContent;
import org.dev.hrm.model.RespPageBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName MsgContentService.java
 * @createTime 2020年04月01日 15:21:00
 */
@Service
public class MsgContentService {

  @Resource
  HrMapper hrMapper;
  @Resource
  private SysmsgMapper sysmsgMapper;
  @Resource
  private MsgContentMapper MsgContentMapper;


  public int deleteByPrimaryKey(Integer id) {
    return MsgContentMapper.deleteByPrimaryKey(id);
  }


  public int insert(MsgContent record) {
    return MsgContentMapper.insert(record);
  }


  public int insertSelective(MsgContent record) {
    return MsgContentMapper.insertSelective(record);
  }


  public MsgContent selectByPrimaryKey(Integer id) {
    return MsgContentMapper.selectByPrimaryKey(id);
  }


  public int updateByPrimaryKeySelective(MsgContent record) {
    return MsgContentMapper.updateByPrimaryKeySelective(record);
  }


  public int updateByPrimaryKey(MsgContent record) {
    return MsgContentMapper.updateByPrimaryKey(record);
  }

  /**
   * //只有管理员可以发送系统消息
   *
   * @param msgContent     消息实体
   * @param authentication
   * @return bool
   */
  @PreAuthorize("hasRole('ROLE_admin')")
  @Transactional(rollbackFor = Exception.class)
  public boolean sendMsg(MsgContent msgContent,
      Authentication authentication) {
    //先插入到MsgContent表
    if (MsgContentMapper.insertSelective(msgContent) == 1) {
      List<Hr> hrList;
      //判断一下authentication是否为空
      Hr currentHr = null;
      if (null == authentication) {
        currentHr = ((Hr) SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal());
      } else {
        currentHr = (Hr) authentication.getPrincipal();
      }
      hrList = hrMapper.selectOtherHrs(currentHr.getId());
      //在把该消息对应的用户插入到SYSMSG表
      return sysmsgMapper.insertHrsMsg(hrList, msgContent.getId()) == hrList
          .size();
    }
    return false;
  }

  /**
   * 获取当前HR的消息内容
   *
   * @param page
   * @param size
   * @return
   */
  public RespPageBean getMyMsgs(Integer page, Integer size) {
    if (page != null && size != null) {
      page = (page - 1) * size;
    }
    Hr currentHr = ((Hr) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal());
    List<MsgContent> data = MsgContentMapper
        .getAllMsg(page, size, currentHr.getId());
    long total = MsgContentMapper.getTotal(currentHr.getId());
    RespPageBean pageBean = new RespPageBean();
    pageBean.setTotal(total);
    pageBean.setData(data);
    return pageBean;
  }

  /**
   * 获取所有消息内容
   *
   * @param page
   * @param size
   * @return
   */
  public RespPageBean getAllMsg(Integer page, Integer size) {
    if (page != null && size != null) {
      page = (page - 1) * size;
    }
    List<MsgContent> data = MsgContentMapper
        .getAllMsg(page, size, null);
    long total = MsgContentMapper.getTotal(null);
    RespPageBean pageBean = new RespPageBean();
    pageBean.setTotal(total);
    pageBean.setData(data);
    return pageBean;
  }

  public RespPageBean getAllNotices(Integer page, Integer size) {
    if (page != null && size != null) {
      page = (page - 1) * size;
    }
    List<MsgContent> data = MsgContentMapper
        .getAllNotices(page, size);
    long total = MsgContentMapper.getNoticesNum();
    RespPageBean pageBean = new RespPageBean();
    pageBean.setTotal(total);
    pageBean.setData(data);
    return pageBean;
  }
}
