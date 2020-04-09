package org.dev.hrm.controller.sal;

import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.AdjustSalary;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.AdjustSalaryService;
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
 * @ClassName AdjustSalaryController.java
 * @createTime 2020年04月09日 15:29:00
 */
@RestController
@RequestMapping("/sal/adjust")
public class AdjustSalaryController {

  @Autowired
  AdjustSalaryService adjustsalaryService;

  @GetMapping("/")
  @WebLogger
  public RespBean getEmployeeTransferInfo(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size, Employee employee) {
    return RespBean.ok("",
        adjustsalaryService
            .getAdjustSalaryByPage(page, size, employee));
  }

  @PutMapping("/")
  @WebLogger
  public RespBean updateAdjustSalaryInfo(
      @RequestBody AdjustSalary adjustSalary) {
    if (adjustsalaryService
        .updateByPrimaryKeySelective(adjustSalary) == 1) {
      return RespBean.ok("更新成功"
      );
    }
    return RespBean.error("更新失败");
  }

  @PostMapping("/")
  @WebLogger
  public RespBean addAdjustSalaryInfo(
      @RequestBody AdjustSalary adjustSalary) {
    if (adjustsalaryService
        .insertSelective(adjustSalary) == 1) {
      return RespBean.ok("新增成功"
      );
    }
    return RespBean.error("新增失败");
  }

  @DeleteMapping("/{ids}")
  @WebLogger
  public RespBean deleteAdjustSalaryInfo(@PathVariable String ids) {
    if (adjustsalaryService.deleteByPrimaryKeys(ids) > 0) {
      return RespBean.ok("删除成功");
    } else {
      return RespBean.error("删除失败");
    }
  }

  @PostMapping("/commit/{id}")
  @WebLogger
  public RespBean commitTransfer(@PathVariable Integer id) {
    AdjustSalary adjustSalary = new AdjustSalary();
    adjustSalary.setId(id);
    adjustsalaryService.commit(adjustSalary);
    if (adjustSalary.getResult() == 1) {
      return RespBean.ok("生效成功"
      );
    }
    return RespBean.error("生效失败,请联系管理员！");
  }
}
