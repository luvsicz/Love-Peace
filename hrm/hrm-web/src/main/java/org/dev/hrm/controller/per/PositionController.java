package org.dev.hrm.controller.per;

import java.util.List;
import org.dev.hrm.annotation.WebLogger;
import org.dev.hrm.model.Position;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.PositionService;
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
@RequestMapping("/per/pos")
public class PositionController {

  @Autowired
  PositionService positionService;

  @GetMapping("/")
  @WebLogger
  public List<Position> getAllPositions() {
    return positionService.getAllPositions();
  }

  @PostMapping("/")
  @WebLogger
  public RespBean addPosition(@RequestBody Position position) {
    if (positionService.addPosition(position) == 1) {
      return RespBean.ok("添加成功!");
    }
    return RespBean.error("添加失败!");
  }

  @PutMapping("/")
  @WebLogger
  public RespBean updatePositions(@RequestBody Position position) {
    if (positionService.updateByPrimaryKeySelective(position) == 1) {
      return RespBean.ok("更新成功!");
    }
    return RespBean.error("更新失败!");
  }

  @DeleteMapping("/{id}")
  @WebLogger
  public RespBean deletePositionById(@PathVariable Integer id) {
    if (positionService.deleteByPrimaryKey(id) == 1) {
      return RespBean.ok("删除成功!");
    }
    return RespBean.error("删除失败!");
  }

  @DeleteMapping("/")
  @WebLogger
  public RespBean deletePositionsByIds(Integer[] ids) {
    if (positionService.deleteByPrimaryKeys(ids) == ids.length) {
      return RespBean.ok("删除成功!");
    }
    return RespBean.error("删除失败!");
  }
}
