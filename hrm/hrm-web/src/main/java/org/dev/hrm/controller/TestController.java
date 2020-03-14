package org.dev.hrm.controller;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.dev.hrm.annotation.ServiceLogger;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.HrExample;
import org.dev.hrm.service.EmployeeService;
import org.dev.hrm.service.HrService;
import org.dev.hrm.util.JackSonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class TestController {

  @Autowired
  EmployeeService employeeService;
  @Autowired
  HrService hrService;

  @RequestMapping("/test")
  @ServiceLogger
  @WebLogger
  String test(String msg) {
    Map<String, String> resultMap = new HashMap<>(2);
    resultMap.put("code", "200");
    resultMap.put("msg", msg == null ? "ok" : msg);
    return JackSonUtils.bean2Json(resultMap);
  }

  @RequestMapping({"/q/{id}", "/q"})
  @ServiceLogger
  @WebLogger
  String query(@PathVariable(value = "id", required = false) Integer id) {
    if (null == id) {
      HrExample hexp = new HrExample();
      hexp.createCriteria().andAddressIsNotNull();
      return JackSonUtils.bean2Json(hrService.selectByExample(hexp));
    } else {
      return JackSonUtils.bean2Json(employeeService.selectByPrimaryKey(id));
    }
  }
}
