package org.dev.hrm.controller.per;

import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Employeetrain;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.EmployeetrainService;
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
 * @ClassName EmployeeTrainController.java
 * @createTime 2020年04月04日 15:42:00
 */
@RestController
@RequestMapping("/per/train")
public class EmployeeTrainController {

  @Autowired
  EmployeetrainService employeetrainService;

  @GetMapping("/")
  @WebLogger
  public RespBean getTrainingInfo(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size) {
    return RespBean
        .ok("", employeetrainService.getTrainingInfoByPage(page, size));
  }

  @DeleteMapping("/{id}")
  @WebLogger
  public RespBean deleteTrainingInfo(@PathVariable Integer id) {
    return employeetrainService.deleteByPrimaryKey(id) == 1 ? RespBean
        .ok("删除成功") : RespBean
        .error("删除失败");
  }

  @PostMapping("/")
  @WebLogger
  public RespBean addTrainingInfo(@RequestBody Employeetrain employeetrain) {
    return employeetrainService.insertSelective(employeetrain) == 1 ? RespBean
        .ok("添加成功") : RespBean
        .error("添加失败");
  }

  @PutMapping("/")
  @WebLogger
  public RespBean updateTrainingInfo(@RequestBody Employeetrain employeetrain) {
    return employeetrainService.updateByPrimaryKeySelective(employeetrain) == 1 ? RespBean
        .ok("更新成功") : RespBean
        .error("更新失败");
  }
}
