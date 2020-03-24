package org.dev.hrm.service;

import java.util.List;
import javax.annotation.Resource;
import org.dev.hrm.mapper.NationMapper;
import org.dev.hrm.model.Nation;
import org.springframework.stereotype.Service;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName NationServices.java
 * @Description TODO
 * @createTime 2020年03月24日 15:45:00
 */
@Service
public class NationService {
  @Resource

  NationMapper mapper;

  public List<Nation> getAllNations() {
    return mapper.selectAllNations();
  }
}
