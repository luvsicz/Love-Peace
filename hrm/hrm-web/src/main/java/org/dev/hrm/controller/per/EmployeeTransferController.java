package org.dev.hrm.controller.per;

import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.EmployeeTransfer;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.EmployeeTransferService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @ClassName EmployeeTransferController.java
 * @createTime 2020年04月08日 14:01:00
 */

@RestController
@RequestMapping("/per/transfer")
public class EmployeeTransferController {

  @Autowired
  EmployeeTransferService employeeTransferService;

  @GetMapping("/")
  @WebLogger
  public RespBean getEmployeeTransferInfo(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size, Employee employee) {
    return RespBean.ok("",
        employeeTransferService
            .getEmployeeTransInfoByPage(page, size, employee));
  }

  @PutMapping("/")
  @WebLogger
  public RespBean updateEmployeeTransferInfo(
      @RequestBody EmployeeTransfer employeeTransfer) {
    if (employeeTransferService
        .updateByPrimaryKeySelective(employeeTransfer) == 1) {
      return RespBean.ok("更新成功"
      );
    }
    return RespBean.error("更新失败");
  }

  @PostMapping("/")
  @WebLogger
  public RespBean addEmployeeTransferInfo(
      @RequestBody EmployeeTransfer employeeTransfer) {
    if (employeeTransferService
        .insertSelective(employeeTransfer) == 1) {
      return RespBean.ok("新增成功"
      );
    }
    return RespBean.error("新增失败");
  }

  @DeleteMapping("/{ids}")
  @WebLogger
  public RespBean deleteEmployeeTransferInfo(@PathVariable String ids) {
    if (employeeTransferService.deleteByPrimaryKeys(ids) > 0) {
      return RespBean.ok("删除成功");
    } else {
      return RespBean.error("删除失败");
    }
  }

  @PostMapping("/commit/{id}")
  @WebLogger
  public RespBean commitTransfer(@PathVariable Integer id) {
    EmployeeTransfer employeeTransfer = new EmployeeTransfer();
    employeeTransfer.setId(id);
    employeeTransferService.commit(employeeTransfer);
    //-1是失败 1 是成功
    if (employeeTransfer.getResult() == 1) {
      return RespBean.ok("生效成功"
      );
    }
    return RespBean.error("生效失败,请联系管理员！");
  }
}
