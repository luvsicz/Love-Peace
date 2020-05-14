package org.dev.hrm;

import static java.util.stream.Collectors.toList;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.dev.hrm.service.AccessLogService;
import org.dev.hrm.service.DepartmentService;
import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.service.HrService;
import org.dev.hrm.util.DateTimeUtils;
import org.dev.hrm.util.JackSonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//2.1.8版本需要加这个才能泡测试类
@RunWith(SpringRunner.class)
@Slf4j
public class HrmServerApplicationTests {

  @Autowired
  HrService hrService;
  @Autowired
  EmployeeService employeeService;
  @Autowired
  DepartmentService departmentService;
  @Autowired
  AccessLogService logService;
  @Value("${spring.mail.username}")
  String mailAddr;

  @Test
  public void loggerTest() {
    logService.getAccessLogByPage(1, 10, null, null);
  }

  @Test
  public void getMaxWorkID() {
    System.out.println(employeeService.getMaxWorkerId());
  }

  @Test
  public void PasswordGen() {
    System.out.println(new BCryptPasswordEncoder().encode("123"));
  }

  @Test
  public void LambdaASEmails() {
    String id = "1931,1932,1933,1934";
    log.info("emails = {}",
             employeeService
                 .getEmailsByPKs(id)
                 .parallelStream()
                 .distinct()
                 .collect(toList())
                 .toString());
  }

  @Test
  public void report() {
    log.info("departmentService.getDepSalReport() = {}",
             JackSonUtils.bean2Json(departmentService.getDepSalReport()));
  }

  @Test
  public void mailTest() {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setSubject("培训通知");
    message.setFrom(mailAddr);
    message.setTo("1610940520@qq.com");
    message.setSentDate(new Date());
    message.setText("请于，" + DateTimeUtils
        .timeStampToDateString(Timestamp.from(Instant.now())) +
                    ","
                    + "参与培训！" +
                    "培训内容："
                    + "ABCDEFG");
    //    javaMailSender.send(message);

  }

  @Test
  public void hello() {
    System.out.println("11");

  }
}
