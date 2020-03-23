package org.dev.hrm.controller.emp;

import java.util.List;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.util.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName EmpBasicController.java
 * @Description TODO
 * @createTime 2020年03月22日 17:35:00
 */
@RestController
@RequestMapping("/employee/")
public class EmpBasicController {

  @Autowired
  EmployeeService service;

  @GetMapping("/")
  public RespBean getEmployeeInfo(@RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size, Employee employee) {
    return RespBean.ok("加载成功", service.getEmployeeByPage(page, size, employee));
  }

  @PostMapping("/")
  public RespBean addEmp(@RequestBody Employee employee) {
    if (service.insert(employee) == 1) {
      return RespBean.ok("添加成功!");
    }
    return RespBean.error("添加失败!");
  }

  @DeleteMapping("/{ids}")
  public RespBean delEmpByPrimaryKey(@PathVariable String ids) {
    boolean flag = service.deleteByPrimaryKeys(ids) > 0;
    return flag ? RespBean.ok("删除成功") : RespBean.error("删除失败");

  }

  @GetMapping("/export")
  public ResponseEntity<byte[]> exportData() {
    List<Employee> list = (List<Employee>) service
        .getEmployeeByPage(null, null, new Employee()).getData();
    return POIUtils.employee2Excel(list);
  }

}
