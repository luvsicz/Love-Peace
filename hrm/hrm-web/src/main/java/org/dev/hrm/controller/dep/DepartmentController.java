package org.dev.hrm.controller.dep;

import java.util.List;
import org.dev.hrm.model.Department;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName DepManageController.java
 * @Description TODO
 * @createTime 2020年03月26日 19:15:00
 */
@RestController
@RequestMapping("/dep/")
public class DepartmentController {

  @Autowired
  DepartmentService service;

  @GetMapping("/")
  public List<Department> getAllDepartments() {
    return service.getAllDepartments();
  }

  @PostMapping("/")
  public RespBean addDep(@RequestBody Department dep) {
    service.addDepartment(dep);
    if (dep.getResult() == 1) {
      return RespBean.ok("添加成功", dep);
    }
    return RespBean.error("添加失败");
  }

  @DeleteMapping("/{id}")
  public RespBean deleteDepById(@PathVariable Integer id) {
    Department dep = new Department();
    dep.setId(id);
    service.delDepartment(dep);
    //根据存储过程的返回值判断结果
    if (dep.getResult() == -2) {
      return RespBean.error("该部门下有子部门，删除失败");
    } else if (dep.getResult() == -1) {
      return RespBean.error("该部门下有员工，删除失败");
    } else if (dep.getResult() == 1) {
      return RespBean.ok("删除成功");
    }
    return RespBean.error("删除失败");
  }
}