package org.dev.hrm.controller.sys;

import java.util.List;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.JobLevel;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/joblevel")
public class JobLevelController {

  @Autowired
  JobLevelService jobLevelService;

  @GetMapping("/")
  @WebLogger
  public List<JobLevel> getAllJobLevels() {
    return jobLevelService.getAllJobLevels();
  }

  @PostMapping("/")
  @WebLogger
  public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
    if (jobLevelService.insertSelective(jobLevel) == 1) {
      return RespBean.ok("添加成功!");
    }
    return RespBean.error("添加失败!");
  }

  @PutMapping("/")
  @WebLogger
  public RespBean updateJobLevelById(@RequestBody JobLevel jobLevel) {
    if (jobLevelService.updateByPrimaryKeySelective(jobLevel) == 1) {
      return RespBean.ok("更新成功!");
    }
    return RespBean.error("更新失败!");
  }

  @DeleteMapping("/{id}")
  @WebLogger
  public RespBean deleteJobLevelById(@PathVariable Integer id) {
    if (jobLevelService.deleteByPrimaryKey(id) == 1) {
      return RespBean.ok("删除成功!");
    }
    return RespBean.error("删除失败!");
  }

  @DeleteMapping("/")
  @WebLogger
  public RespBean deleteJobLevelsByIds(Integer[] ids) {
    if (jobLevelService.deleteByPrimaryKeys(ids) == ids.length) {
      return RespBean.ok("删除成功!");
    }
    return RespBean.error("删除失败!");
  }
}