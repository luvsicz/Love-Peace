package org.dev.hrm.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Str2DateConverter.java
 * @Description Str转换成指定日期格式
 * @createTime 2020年03月29日 14:31:00
 */
@Component
@Slf4j
public class Str2DateConverter implements Converter<String, Date> {

  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  @Override
  public Date convert(String source) {
    try {
      return sdf.parse(source);
    } catch (ParseException e) {
      log.error("日期转换异常:"+e);
    }
    return null;
  }
}
