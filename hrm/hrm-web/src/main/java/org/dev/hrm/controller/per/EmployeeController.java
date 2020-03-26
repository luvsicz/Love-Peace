package org.dev.hrm.controller.per;

import java.util.Date;
import java.util.List;
import org.dev.hrm.model.Department;
import org.dev.hrm.model.Employee;
import org.dev.hrm.model.JobLevel;
import org.dev.hrm.model.Nation;
import org.dev.hrm.model.PoliticsStatus;
import org.dev.hrm.model.Position;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.DepartmentService;
import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.service.JobLevelService;
import org.dev.hrm.service.NationService;
import org.dev.hrm.service.PoliticsStatusService;
import org.dev.hrm.service.PositionService;
import org.dev.hrm.util.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/per/emp")
public class EmployeeController {

  @Autowired
  EmployeeService empService;
  @Autowired

  DepartmentService departmentService;
  @Autowired
  NationService nationService;
  @Autowired
  PoliticsStatusService politicsStatusService;
  @Autowired
  JobLevelService jobLevelService;
  @Autowired
  PositionService positionService;

  @GetMapping("/")
  public RespBean getEmployeeInfo(@RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
    return RespBean.ok("", empService.getEmployeeByPage(page, size, employee, beginDateScope));
  }

  /**
   * 新增
   *
   * @param employee
   * @return
   */
  @PostMapping("/")
  public RespBean addEmp(@RequestBody Employee employee) {
    if (empService.insert(employee) == 1) {
      return RespBean.ok("添加成功!");
    }
    return RespBean.error("添加失败!");
  }

  @DeleteMapping("/{ids}")
  public RespBean delEmpByPrimaryKey(@PathVariable String ids) {
    if (empService.deleteByPrimaryKeys(ids) > 0) {
      return RespBean.ok("删除成功");
    } else {
      return RespBean.error("删除失败");
    }

  }

  /**
   * 更新
   *
   * @param employee
   * @return
   */
  @PutMapping
  public RespBean updateEmployee(@RequestBody Employee employee) {
    if (empService.updateByPrimaryKeySelective(employee) == 1) {
      return RespBean.ok("更新成功");
    } else {
      return RespBean.error("更新失败");
    }
  }

  @GetMapping("/export")
  public ResponseEntity<byte[]> exportData() {
    List<Employee> list = (List<Employee>) empService
        .getEmployeeByPage(null, null, new Employee(), null).getData();
    return POIUtils.employee2Excel(list);
  }

  @GetMapping("/nations")
  public List<Nation> getAllNations() {
    return nationService.getAllNations();
  }

  @GetMapping("/politicsstatus")
  public List<PoliticsStatus> getAllPoliticsstatus() {
    return politicsStatusService.getAllPoliticsStatus();
  }

  @GetMapping("/joblevels")
  public List<JobLevel> getAllJobLevels() {
    return jobLevelService.getAllJobLevels();
  }

  @GetMapping("/positions")
  public List<Position> getAllPositions() {
    return positionService.getAllPositions();
  }

  @GetMapping("/availableWorkId")
  public RespBean availableWorkId() {
    return RespBean.build().setStatus(200)
        .setObj(String.format("%08d", empService.getMaxWorkerId() + 1));
  }

  @GetMapping("/deps")
  public List<Department> getAllDepartments() {
    return departmentService.getAllDepartments();
  }

}
