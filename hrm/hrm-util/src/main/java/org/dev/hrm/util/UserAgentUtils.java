package org.dev.hrm.util;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.UserAgent;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName UserAgentUtils.java
 * @Description 客户端UserAgent判断工具类
 * @createTime 2019年12月15日 21:36:00
 */
public class UserAgentUtils {

  private UserAgentUtils() {
    throw new IllegalStateException("UserAgentUtils.class");
  }

  /**
   * 获取用户代理对象
   *
   * @param request HttpServletRequest
   * @return 返回用户代理对象UserAgent
   */
  public static UserAgent getUserAgent(HttpServletRequest request) {
    return UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
  }

  /**
   * 获取设备类型
   *
   * @param request HttpServletRequest
   * @return 返回设备类型
   */
  public static DeviceType getDeviceType(HttpServletRequest request) {
    return getUserAgent(request).getOperatingSystem().getDeviceType();
  }

  /**
   * 是否是PC
   *
   * @param request HttpServletRequest
   * @return 是否是PC
   */
  public static boolean isComputer(HttpServletRequest request) {
    return DeviceType.COMPUTER.equals(getDeviceType(request));
  }

  /**
   * 是否是手机
   *
   * @param request HttpServletRequest
   * @return 是否是手机
   */
  public static boolean isMobile(HttpServletRequest request) {
    return DeviceType.MOBILE.equals(getDeviceType(request));
  }

  /**
   * 是否是平板
   *
   * @param request HttpServletRequest
   * @return 是否是平板
   */
  public static boolean isTablet(HttpServletRequest request) {
    return DeviceType.TABLET.equals(getDeviceType(request));
  }

  /**
   * 是否是手机和平板
   *
   * @param request HttpServletRequest
   * @return 是否是手机和平板
   */
  public static boolean isMobileOrTablet(HttpServletRequest request) {
    DeviceType deviceType = getDeviceType(request);
    return DeviceType.MOBILE.equals(deviceType) || DeviceType.TABLET
        .equals(deviceType);
  }

  /**
   * 获取浏览类型
   *
   * @param request HttpServletRequest
   * @return 获取浏览类型
   */
  public static Browser getBrowser(HttpServletRequest request) {
    return getUserAgent(request).getBrowser();
  }

  /**
   * 是否IE版本是否小于等于IE8
   *
   * @param request HttpServletRequest
   * @return 是否IE版本是否小于等于IE8
   */
  public static boolean isLteIE8(HttpServletRequest request) {
    Browser browser = getBrowser(request);
    return Browser.IE5.equals(browser) || Browser.IE6.equals(browser)
        || Browser.IE7.equals(browser) || Browser.IE8.equals(browser);
  }
}
