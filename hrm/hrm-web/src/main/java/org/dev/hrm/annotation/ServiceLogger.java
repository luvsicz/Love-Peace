package org.dev.hrm.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName ServiceLogger.java
 * @Description Service层调用日志
 * @createTime 2019年12月15日 22:20:00
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLogger {

}
