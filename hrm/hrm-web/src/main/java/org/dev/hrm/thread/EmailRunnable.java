package org.dev.hrm.thread;

import java.util.Date;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.Employeetrain;
import org.dev.hrm.util.DateTimeUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmailRunnable.java
 * @createTime 2020年04月15日 12:54:00
 */
public class EmailRunnable implements Runnable {

  JavaMailSender javaMailSender;
  Employee emp;
  Employeetrain employeetrain;
  String mailAddr;

  public EmailRunnable(
      JavaMailSender javaMailSender, Employee emp,
      Employeetrain employeetrain, String mailAddr) {
    this.javaMailSender = javaMailSender;
    this.emp = emp;
    this.employeetrain = employeetrain;
    this.mailAddr = mailAddr;
  }

  @Override
  public void run() {
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
  }
}
