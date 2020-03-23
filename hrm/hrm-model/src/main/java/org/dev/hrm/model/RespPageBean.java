package org.dev.hrm.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName RespPageBean.java
 * @Description TODO
 * @createTime 2020年03月23日 16:18:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespPageBean {

  long total;
  List<?> data;

}
