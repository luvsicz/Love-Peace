package org.dev.hrm.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName HrRole.java
 * @createTime 2020年03月18日 15:49:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class HrRole implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private Integer hrid;

  private Integer rid;
}