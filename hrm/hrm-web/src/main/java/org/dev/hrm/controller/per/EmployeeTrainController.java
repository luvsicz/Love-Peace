package org.dev.hrm.controller.per;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Resource;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.Employeetrain;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.service.EmployeetrainService;
import org.dev.hrm.thread.EmailRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmployeeTrainController.java
 * @createTime 2020年04月04日 15:42:00
 */
@RestController
@RequestMapping("/per/train")
public class EmployeeTrainController {

  @Autowired
  EmployeetrainService employeetrainService;
  @Autowired
  EmployeeService employeeService;
  @Resource
  JavaMailSender javaMailSender;
  @Autowired
  ExecutorService executorService;
  @Value("${spring.mail.username}")
  String mailAddr;


  @GetMapping("/")
  @WebLogger
  public RespBean getTrainingInfo(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size) {
    return RespBean
        .ok("", employeetrainService.getTrainingInfoByPage(page, size));
  }

  @DeleteMapping("/{id}")
  @WebLogger
  public RespBean deleteTrainingInfo(@PathVariable Integer id) {
    return employeetrainService.deleteByPrimaryKey(id) == 1 ? RespBean
        .ok("删除成功") : RespBean
        .error("删除失败");
  }

  @PostMapping("/")
  @WebLogger
  public RespBean addTrainingInfo(@RequestBody Employeetrain employeetrain) {
    Employee emp = employeeService.selectByPrimaryKey(employeetrain.getEid());
    String ids = "";
    List<String> emails = employeeService.getEmailsByPKs(ids);
    if (employeetrainService.insertSelective(employeetrain) == 1) {
      //提交发送邮件的任务给线程池
      executorService.execute(new EmailRunnable(javaMailSender, emp,
                                                employeetrain, mailAddr));
      return RespBean
          .ok("培训添加成功，会有邮件通知该员工！");
    }
    return RespBean
        .error("添加失败");
  }

  @PutMapping("/")
  @WebLogger
  public RespBean updateTrainingInfo(@RequestBody Employeetrain employeetrain) {
    Employee emp = employeeService.selectByPrimaryKey(employeetrain.getEid());
    if (employeetrainService.updateByPrimaryKeySelective(employeetrain) == 1) {
      //提交发送邮件的任务给线程池
      executorService.execute(new EmailRunnable(javaMailSender, emp,
                                                employeetrain, mailAddr));
      return RespBean.ok("更新成功");
    }
    return RespBean.error("更新失败");
  }

  /**
   * 发送邮件的线程池
   *
   * @return 线程池
   */
  @Bean
  public ExecutorService executorService() {
    return Executors.newCachedThreadPool();
  }
}
