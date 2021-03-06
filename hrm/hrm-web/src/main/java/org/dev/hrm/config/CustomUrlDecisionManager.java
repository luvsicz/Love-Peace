package org.dev.hrm.config;

import java.util.Collection;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * @Description 判断当前请求的用户是否具有该url的访问权限
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {

  @Override
  public void decide(Authentication authentication, Object object,
      Collection<ConfigAttribute> configAttributes)
      throws AccessDeniedException, InsufficientAuthenticationException {
    //判断用户是否具有指定URL的访问权限
    for (ConfigAttribute configAttribute : configAttributes) {
      String needRole = configAttribute.getAttribute();
      if ("ROLE_LOGIN".equals(needRole)) {
        if (authentication instanceof AnonymousAuthenticationToken) {
          throw new AccessDeniedException("尚未登录，请登录!");
        } else {
          //已经登录
          return;
        }
      }
      Collection<? extends GrantedAuthority> authorities
          = authentication.getAuthorities();
      for (GrantedAuthority authority : authorities) {
        if (authority.getAuthority().equals(needRole)) {
          //通过校验
          return;
        }
      }
    }
    throw new AccessDeniedException("权限不足，请联系管理员!");
  }

  @Override
  public boolean supports(ConfigAttribute attribute) {
    return true;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return true;
  }
}
