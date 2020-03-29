package org.dev.hrm.controller.sal;

import java.util.List;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.model.Salary;
import org.dev.hrm.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName SalaryController.java
 * @createTime 2020年03月29日 15:16:00
 */
@RestController
@RequestMapping("/sal/sob")
public class SalaryController {

  @Autowired
  SalaryService salaryService;

  @GetMapping("/")
  public List<Salary> getAllSalaries() {
    return salaryService.getAllSalaries();
  }

  @PostMapping("/")
  public RespBean addSalary(@RequestBody Salary salary) {
    if (salaryService.insertSelective(salary) == 1) {
      return RespBean.ok("添加成功!");
    }
    return RespBean.error("添加失败!");
  }

  @DeleteMapping("/{id}")
  public RespBean deleteSalaryById(@PathVariable Integer id) {
    if (salaryService.deleteByPrimaryKey(id) == 1) {
      return RespBean.ok("删除成功！");
    }
    return RespBean.error("删除失败！");
  }

  @PutMapping("/")
  public RespBean updateSalaryById(@RequestBody Salary salary) {
    if (salaryService.updateByPrimaryKeySelective(salary) == 1) {
      return RespBean.ok("更新成功!");
    }
    return RespBean.error("更新失败!");
  }
}
