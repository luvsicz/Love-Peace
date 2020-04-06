package org.dev.hrm.controller.per;

import java.util.Date;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.Employeetrain;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.service.EmployeetrainService;
import org.dev.hrm.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
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
  @Autowired
  JavaMailSender javaMailSender;

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
    if (employeetrainService.insertSelective(employeetrain) == 1) {
      //发送邮件
      String empEmail = emp.getEmail();
      SimpleMailMessage message = new SimpleMailMessage();
      message.setSubject("培训通知");
      message.setFrom(mailAddr);
      message.setTo(empEmail);
      message.setSentDate(new Date());
      message
          .setText(emp.getName() +
              ("男".equals(emp.getGender()) ? "先生," : "女士,")
              + "请于" + DateTimeUtils
              .timeStampToDateString(employeetrain.getTrainDate())
              + ",在" + employeetrain.getRemark()
              + "参与培训" +
              ",培训内容："
              + employeetrain.getTrainContent());
      javaMailSender.send(message);
      return RespBean
          .ok("培训添加成功，会有邮件通知该员工！");
    }
    return RespBean
        .error("添加失败");
  }

  @PutMapping("/")
  @WebLogger
  public RespBean updateTrainingInfo(@RequestBody Employeetrain employeetrain) {
    return employeetrainService.updateByPrimaryKeySelective(employeetrain) == 1
        ? RespBean
        .ok("更新成功") : RespBean
        .error("更新失败");
  }
}
