package org.dev.hrm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName JackSonUtils.java
 * @Description 序列化/反序列化工具
 * @createTime 2019年12月15日 21:04:00
 */
public class JackSonUtils {

  private static ObjectMapper mapper = new ObjectMapper();

  private JackSonUtils() {
    throw new IllegalStateException("JackSonUtils.class");
  }

  public static String bean2Json(Object obj) {
    try {
      return mapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String bean2Json(Object obj, boolean isFormated) {
    if (isFormated) {
      mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
    try {
      return mapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
    try {
      return mapper.readValue(jsonStr, objClass);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
