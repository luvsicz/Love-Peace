package org.dev.hrm.controller.sys;

import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.MsgContent;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.MsgContentService;
import org.dev.hrm.service.SysmsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName NotificationController.java 系统通知的整个处理流程是这样的：
 * 1.用户登录成功来到Home页面后，会主动发起一次请求，查看是否有未读通知，如果有，则弹出通知 2.管理员通过发送了系统通知之后，会由websocket主动推送一条消息，告诉当前登录的HR用户有新通知
 * 3.用户打开系统通知页面后，未读通知会有蓝字标记，打开该通知后，该通知就变为已读通知 4.通知的发送则是先由前端发起请求，向数据库中添加一条记录，添加成功后，再发送一条群发通知的请求
 * @createTime 2020年04月01日 15:08:00
 */
@RequestMapping("/sys/nf")
@RestController
public class NotificationController {

  @Autowired
  SysmsgService sysmsgService;
  @Autowired
  MsgContentService msgContentService;
  @Autowired
  private SimpMessagingTemplate simpMessageSendingOperations;//消息发送模板

  /**
   * 获取数据库中的通知
   *
   * @param page
   * @param size
   * @return
   */
  @GetMapping("/")
  @WebLogger
  public RespBean getAllNotices(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size) {
    return RespBean.ok("",
                       msgContentService.getAllNotices(page, size));
  }

  @DeleteMapping("/")
  @WebLogger
  public RespBean deleteMyNotice(@RequestParam Integer mid) {
    return msgContentService.deleteByPrimaryKey(mid) == 1 ? RespBean.ok(
        "删除成功") :
        RespBean.error("删除通知失败");
  }

  @PutMapping("/{ids}")
  @WebLogger
  public RespBean updateNotificationsState(@PathVariable String ids) {
    sysmsgService.updateByPrimaryKeysSelective(ids);
    return RespBean.ok("");
  }

  //客户端建立WS连接的地址:/im/ep
  //客户端发送消息给服务端的地址:/im/send
  //客户端接受消息订阅的地址:/notice
  @MessageMapping("/im/send")
  @SendTo("/notice") //也可以使用 messagingTemplate.convertAndSend(); 推送
  //FIXED 这里徐需要带参数Authentication authentication，否则取不到Security的信息
  public MsgContent sendPublicMessage(@Payload MsgContent msgContent,
                                      Authentication authentication) {
    msgContentService.sendMsg(msgContent, authentication);
    return msgContent;
  }

  //由后台发送到浏览器服务
  //定时5秒给页面推一次数据
  //TODO ws保活
/*  @Scheduled(fixedRate = 1000)//1s
  public void sendMessage() {
    log.error("任务执行");
    simpMessageSendingOperations.convertAndSend("/keepALive",
        "hello");
  }*/

}
