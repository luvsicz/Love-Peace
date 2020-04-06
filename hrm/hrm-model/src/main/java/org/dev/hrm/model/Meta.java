package org.dev.hrm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Meta.java
 * @createTime 2020年03月18日 16:22:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta {


  private Boolean keepAlive;

  private Boolean requireAuth;

}
