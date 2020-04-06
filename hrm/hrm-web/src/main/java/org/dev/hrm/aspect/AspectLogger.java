package org.dev.hrm.aspect;

import eu.bitwalker.useragentutils.UserAgent;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.dev.hrm.model.AccessLog;
import org.dev.hrm.model.Hr;
import org.dev.hrm.service.AccessLogService;
import org.dev.hrm.util.IPUtils;
import org.dev.hrm.util.JackSonUtils;
import org.dev.hrm.util.UserAgentUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Aspect.java
 * @Description 切面日志记录
 * @createTime 2019年12月14日 15:26:00
 */
@Slf4j
@Aspect
@Component
public class AspectLogger {

  @Resource
  AccessLogService service;

  /**
   * String 转Map
   *
   * @param mapString     待转的String
   * @param separator     分割符
   * @param pairSeparator 分离器
   * @return
   */
  public static Map<String, Object> transStringToMap(String mapString,
      String separator,
      String pairSeparator) {
    Map<String, Object> map = new HashMap<>();
    String[] fSplit = mapString.split(separator);
    for (String s : fSplit) {
      if (s == null || s.length() == 0) {
        continue;
      }
      String[] sSplit = s.split(pairSeparator);
      String value = s.substring(s.indexOf('=') + 1);
      map.put(sSplit[0], value);
    }
    return map;
  }

  //    @Pointcut(value = "execution(  * org.dev.hrm.hrmserver.controller..*(
  //    ..))")
  @Pointcut("@annotation(org.dev.hrm.annotation.WebLogger)")
  public void httpWebLog() {
  }

  //    @Pointcut(value = "execution(  * org.dev.hrm.hrmserver.service..*(..))")
  @Pointcut("@annotation(org.dev.hrm.annotation.ServiceLogger)")
  public void serviceAspect() {
  }

  /**
   * 前置通知 用于拦截Controller层记录用户的操作
   *
   * @param joinPoint 切点
   */
  @Before("httpWebLog()")
  public void doBefore(JoinPoint joinPoint) {
    AccessLog accessLog = new AccessLog();
    try {
      HttpServletRequest request = ((ServletRequestAttributes) Objects
          .requireNonNull(RequestContextHolder.getRequestAttributes()))
          .getRequest();
      SecurityContextHolder.getContext().getAuthentication();
      Hr currentHr = (Hr) SecurityContextHolder.getContext().getAuthentication()
          .getPrincipal();
      //类名
      String className = joinPoint.getTarget().getClass().getName();
      //请求方法
      String method = joinPoint.getSignature().getName() + "()";
      //HTTP请求方法参数
      String methodParam = JackSonUtils.bean2Json(joinPoint.getArgs(), false);
      Map<String, String[]> params = request.getParameterMap();
      StringBuilder decode = new StringBuilder();
      //针对get请求
      if (request.getQueryString() != null) {
        decode = new StringBuilder(URLDecoder
            .decode(request.getQueryString(), StandardCharsets.UTF_8));
      } else {
        //针对post请求
        for (String key : params.keySet()) {
          String[] values = params.get(key);
          for (String value : values) {
            decode.append(key).append("=").append(value).append("&");
          }
        }
      }
      //将String根据&转成Map
      Map<String, Object> methodParamMap = transStringToMap(decode.toString(),
          "&", "=");
      //设置日期格式
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      //方法描述
//            String methodDescription = getControllerMethodDescription
//            (joinPoint);
      StringBuilder sb = new StringBuilder(1000);
      sb.append("\n");
      sb.append(
          "*********************************Request" +
              "请求***************************************");
      sb.append("\n");
      sb.append("ClassName     :  ").append(className).append("\n");
      accessLog.setClassName(className);
      sb.append("RequestMethod :  ").append(method).append("\n");
      accessLog.setRequestMethod(method);
      sb.append("ContentType   :  ").append(("".equals(request.getContentType())
          || request.getContentType() == null) ? "FORM"
          : request.getContentType()).append("\n");
      accessLog.setContentType(("".equals(request.getContentType())
          || request.getContentType() == null) ? "FORM"
          : request.getContentType());
      sb.append("RequestParams :  ")
          .append("".equals(decode.toString()) ? methodParam :
              methodParamMap)
          .append("\n");
      accessLog
          .setRequestParams(
              "".equals(decode.toString()) ? JackSonUtils.bean2Json(methodParam)
                  :
                      JackSonUtils.bean2Json(methodParamMap));
      sb.append("RequestType   :  ").append(request.getMethod()).append("\n");
      accessLog.setRequestType(request.getMethod());
      sb.append("ServerAddr    :  ").append(request.getScheme()).append("://")
          .append(request.getServerName()).append(":")
          .append(request.getServerPort()).append("\n");
      accessLog.setServerAddr(request.getScheme() + "://"
          + request.getServerName() + ":"
          + request.getServerPort());
      sb.append("RemoteAddr    :  ").append(IPUtils.getRemoteAddr(request))
          .append("\n");
      accessLog.setRemoteAddr(IPUtils.getRemoteAddr(request));
      UserAgent userAgent = UserAgentUtils.getUserAgent(request);
      sb.append("DeviceName    :  ")
          .append(userAgent.getOperatingSystem().getName()).append("\n");
      accessLog.setDeviceName(userAgent.getOperatingSystem().getName());
      sb.append("BrowserName   :  ").append(userAgent.getBrowser().getName())
          .append("\n");
      accessLog.setBrowserName(userAgent.getBrowser().getName());
      sb.append("UserAgent     :  ").append(request.getHeader("User-Agent"))
          .append("\n");
      accessLog.setUserAgent(request.getHeader("User-Agent"));
      sb.append("RequestUri    :  ").append(request.getRequestURI())
          .append("\n");
      accessLog.setRequestUri(request.getRequestURI());
      sb.append("******************************");
      sb.append(df.format(new Date()));
//      Timestamp.valueOf(df.format(new Date());
      accessLog.setRequestTime(new Timestamp(System.currentTimeMillis()));
      sb.append("***********************************");
      sb.append("\n");
      accessLog.setHrid(currentHr.getId());
      service.insertSelective(accessLog);
//      log.info(sb.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @AfterReturning(returning = "ret", pointcut = "httpWebLog()")
  public void doAfterReturning(Object ret) {
    HttpServletRequest request =
        ((ServletRequestAttributes) Objects
            .requireNonNull(RequestContextHolder.getRequestAttributes()))
            .getRequest();
    //请求方法
    String method = request.getRequestURI();
    StringBuilder sb = new StringBuilder(1000);
    // 处理完请求，返回内容
    sb.append("\n");
    sb.append("Result        :  ").append(JackSonUtils.bean2Json(ret));
//    log.info(sb.toString());
  }


  /**
   * 异常通知 用于拦截service层记录异常日志
   *
   * @param joinPoint
   * @param ex
   */
  @AfterThrowing(pointcut = "serviceAspect()", throwing = "ex")
  public void doAfterThrowing(JoinPoint joinPoint, Throwable ex) {
    try {
      HttpServletRequest request =
          ((ServletRequestAttributes) Objects
              .requireNonNull(RequestContextHolder.getRequestAttributes()))
              .getRequest();
      //类名
      String className = joinPoint.getTarget().getClass().getName();
      //请求方法
      String method = (joinPoint.getTarget().getClass().getName() + "."
          + joinPoint.getSignature().getName() +
          "()");
      //方法参数
      String methodParam = Arrays.toString(joinPoint.getArgs());
      //方法描述
//            String methodDescription = getServiceMthodDescription(joinPoint);
      //获取用户请求方法的参数并序列化为JSON格式字符串
      StringBuilder params = new StringBuilder();
      if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
          params.append(JackSonUtils.bean2Json(joinPoint.getArgs()[i], false))
              .append(";");
        }
      }
      StringBuilder sb = new StringBuilder(1000);
      sb.append("\n");
      sb.append(
          "*********************************Service" +
              "异常***************************************");
      sb.append("\n");
      sb.append("ClassName        :  ").append(className).append("\n");
      sb.append("Method           :  ").append(method).append("\n");
      sb.append("Params           :  ").append("[").append(params).append("]")
          .append("\n");
//            sb.append("Description      :  ").append(methodDescription)
//            .append("\n");
      sb.append("ExceptionName    :  ").append(ex.getClass().getName())
          .append("\n");
      sb.append("ExceptionMessage :  ").append(ex.getMessage()).append("\n");
//      log.info(sb.toString());
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }
}
