package org.dev.hrm;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.dev.hrm.service.AccessLogService;
import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.service.HrService;
import org.dev.hrm.util.DateTimeUtils;
import org.junit.jupiter.api.DisplayName;
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
  @Autowired
  JavaMailSender javaMailSender;
  @Value("${spring.mail.username}")
  String mailAddr;

  @Test
  void loggerTest() {
    logService.getAccessLogByPage(1, 10, null, null);
  }


  @Test
  @DisplayName("HR查询测试")
  void queryHr() {
//    HrExample exp = new HrExample();
//    exp.createCriteria().andPasswordIsNotNull().andAddressIsNotNull();
//    List<Hr> hrExampleList = hrService.selectByExample(exp);
//    log.info("\n HR Query Result Size:{}", hrExampleList.size());
  }

  @Test
  void 密码生成() {
    System.out.println(new BCryptPasswordEncoder().encode("123"));
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

  @Test
  @DisplayName("Employee查询测试")
  void queryEmployee() {
//    EmployeeExample exp = new EmployeeExample();
//    exp.createCriteria().andAddressIsNotNull().andPhoneIsNotNull().andSchoolIsNotNull();
//    List<Employee> employeeList = employeeService.selectByExample(exp);
//    log.info("\n Employee Query Result Size:{}", employeeList.size());
  }
}
