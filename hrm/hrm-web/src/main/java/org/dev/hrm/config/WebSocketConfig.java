package org.dev.hrm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName WebSocketConfig.java
 * @createTime 2020年04月01日 16:07:00
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    //允许客户端使用socketJs方式访问，访问点为ws，允许跨域,建立连接
    registry.addEndpoint("/im/ep").setAllowedOrigins("*").withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {

    //订阅广播 Broker（消息代理）名称
    registry.enableSimpleBroker("/notice");
  }
}