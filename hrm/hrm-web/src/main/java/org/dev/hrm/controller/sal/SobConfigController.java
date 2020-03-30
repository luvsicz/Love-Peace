package org.dev.hrm.controller.sal;

import java.util.List;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.model.RespPageBean;
import org.dev.hrm.model.Salary;
import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName SobConfigController.java

 * @createTime 2020年03月29日 15:16:00
 */

@RestController
@RequestMapping("/sal/sobcfg")
public class SobConfigController {

  @Autowired
  EmployeeService employeeService;
  @Autowired
  SalaryService salaryService;

  @GetMapping("/")
  @WebLogger
  public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size) {
    return employeeService.getEmployeeByPageWithSalary(page, size,null);
  }

  @GetMapping("/salaries")
  @WebLogger
  public List<Salary> getAllSalaries() {
    return salaryService.getAllSalaries();
  }

  @PutMapping("/")
  @WebLogger
  public RespBean updateEmployeeSalaryById(Integer eid, Integer sid) {
    Integer result = employeeService.updateEmployeeSalaryById(eid, sid);
    if (result == 1 || result == 2) {
      return RespBean.ok("更新成功");
    }
    return RespBean.error("更新失败");
  }
}
