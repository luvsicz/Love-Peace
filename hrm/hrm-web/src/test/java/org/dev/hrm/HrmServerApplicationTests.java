package org.dev.hrm;

import static java.util.stream.Collectors.toList;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.dev.hrm.service.AccessLogService;
import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.service.HrService;
import org.dev.hrm.util.DateTimeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@Slf4j
class HrmServerApplicationTests {

  @Autowired
  HrService hrService;
  @Autowired
  EmployeeService employeeService;
  @Autowired
  AccessLogService logService;
  @Resource
  JavaMailSender javaMailSender;
  @Value("${spring.mail.username}")
  String mailAddr;

  @Test
  void loggerTest() {
    logService.getAccessLogByPage(1, 10, null, null);
  }

  @Test
  void getMaxWorkID() {
    System.out.println(employeeService.getMaxWorkerId());
  }

  @Test
  void PasswordGen() {
    System.out.println(new BCryptPasswordEncoder().encode("123"));
  }

  @Test
  void LambdaASEmails() {
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
  void mailTest() {
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
}
