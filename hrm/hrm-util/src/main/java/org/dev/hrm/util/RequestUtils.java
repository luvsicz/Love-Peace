package org.dev.hrm.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName RequestUtils.java
 * @createTime 2020年04月07日 13:38:00
 */
public class RequestUtils {

  private RequestUtils() {
  }

  /**
   * 读取HttpServletRequest postData为对象
   *
   * @param req       读取HttpServletRequest
   * @param paramName 取的字段名称
   * @return
   */
  public static String getFormDateParameter(HttpServletRequest req,
      String paramName) {
    StringBuilder sb = new StringBuilder();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node;
    String result;
    try {
      BufferedReader
          br = new BufferedReader(new InputStreamReader(req.getInputStream()));

      String s;
      while ((s = br.readLine()) != null) {
        sb.append(s);
      }
      node = mapper.readTree(sb.toString());
      result = node.get(paramName).toString().replaceAll("\"", "");
      return result;
    } catch (IOException | NullPointerException e) {
      //获取参数失败
      return null;
    }
  }

  public static String transFormDataToString(HttpServletRequest req) {
    StringBuilder sb = new StringBuilder();
    try {
      BufferedReader
          br = new BufferedReader(new InputStreamReader(req.getInputStream()));

      String s;
      while ((s = br.readLine()) != null) {
        sb.append(s);
      }
      return sb.toString();
    } catch (IOException e) {
      //获取参数失败
      return null;
    }
  }
}
