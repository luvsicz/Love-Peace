package org.dev.hrm.util;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName IPUtils.java
 * @Description 客户端IP获取工具类
 * @createTime 2019年12月15日 21:38:00
 */
public class IPUtils {

  public static final String UNKNOWN = "unknown";

  private IPUtils() {
    throw new IllegalStateException("IPUtils.class");
  }

  /**
   * 获取客户端IP地址
   *
   * @param request HttpServletRequest
   * @return 客户端IP地址
   */
  public static String getRemoteAddr(HttpServletRequest request) {
    if (request == null) {
      return UNKNOWN;
    }
    String ip = request.getHeader("X-Forwarded-For");
    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
      ip = request.getHeader("X-Real-IP");
    }
    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    return StringUtils.split(ip, ",")[0];
  }

}
