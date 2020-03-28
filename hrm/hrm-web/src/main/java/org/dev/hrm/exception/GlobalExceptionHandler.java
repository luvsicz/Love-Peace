package org.dev.hrm.exception;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import org.dev.hrm.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName GlobalExceptionHandler.java
 * @createTime 2020年03月27日 17:32:00
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(SQLException.class)
  public RespBean SQLExceptionHandler(SQLException e) {
    if (e instanceof SQLIntegrityConstraintViolationException) {
      return RespBean.error("本次操作违反外键约束，操作失败!");
    }
    return RespBean.error("数据库异常!");
  }

}
