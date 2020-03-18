package org.dev.hrm;

import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.EmployeeExample;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.HrExample;
import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.service.HrService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@Slf4j
class HrmServerApplicationTests {

  @Autowired
  HrService hrService;
  @Autowired
  EmployeeService employeeService;

  /**
   * @throws IOException
   */
  @Test
  void contextLoads() throws IOException {
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
  @DisplayName("Employee查询测试")
  void queryEmployee() {
//    EmployeeExample exp = new EmployeeExample();
//    exp.createCriteria().andAddressIsNotNull().andPhoneIsNotNull().andSchoolIsNotNull();
//    List<Employee> employeeList = employeeService.selectByExample(exp);
//    log.info("\n Employee Query Result Size:{}", employeeList.size());
  }
}
