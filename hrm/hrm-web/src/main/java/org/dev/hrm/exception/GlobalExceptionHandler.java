package org.dev.hrm.exception;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.dev.hrm.model.RespBean;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName GlobalExceptionHandler.java
 * @createTime 2020年03月27日 17:32:00
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  /**
   * 处理SQL的异常
   */
  @ExceptionHandler(SQLException.class)
  public RespBean constraintViolationException(SQLException e) {
    if (e instanceof SQLIntegrityConstraintViolationException) {
      log.error("异常:本次操作违反外键约束，操作失败!", e);
      return RespBean.error("本次操作违反外键约束，操作失败!");
    }
    return RespBean.error("数据库异常!");
  }

  /**
   * 处理空指针的异常
   */
  @ExceptionHandler(value = NullPointerException.class)
  @ResponseBody
  public RespBean exceptionHandler(NullPointerException e) {
    log.error("异常:空指针异常", e);
    return RespBean.error("空指针异常");
  }

  /**
   * 处理请求方式不合法的异常
   */
  @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
  @ResponseBody
  public RespBean exceptionHandler(HttpRequestMethodNotSupportedException e) {
    log.error("异常:请求方式不合法", e);
    return RespBean.error("请求方式不合法");
  }
  /**
   * 处理请求方式不合法的异常
   */
  @ExceptionHandler(value = HttpMessageNotWritableException.class)
  @ResponseBody
  public RespBean exceptionHandler(HttpMessageNotWritableException e) {
    log.error("异常:参数转换异常", e);
    return RespBean.error("参数转换异常");
  }


  /**
   * 处理其他异常 404 这里无法处理
   * 不仅仅404异常，Servlet Filter中的异常@ExceptionHandler也处理不了， @ExceptionHandler的处理器是一个HandlerExceptionResolver的实现类，
   * 而HandlerExceptionResolver处理的是DispatcherServlet处理请求中的异常，所以没到Servlet的在Filter中的异常使用@ExceptionHandler也不行
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public RespBean exceptionHandler(Exception e) {
    log.error("异常:未知异常", e);
    return RespBean.error("未知异常");
  }
}
