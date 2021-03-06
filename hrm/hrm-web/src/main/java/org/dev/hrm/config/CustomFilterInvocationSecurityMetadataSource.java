package org.dev.hrm.config;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.dev.hrm.model.Menu;
import org.dev.hrm.model.Role;
import org.dev.hrm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

/**
 * 这个类的作用，主要是根据用户传来的请求地址，分析出请求需要的角色
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements
                                                          FilterInvocationSecurityMetadataSource {

  @Autowired
  MenuService menuService;
  AntPathMatcher antPathMatcher = new AntPathMatcher();

  @Override
  public Collection<ConfigAttribute> getAttributes(Object object) {
    String requestUrl = ((FilterInvocation) object).getRequestUrl();
    //引入Redis缓存，先去Redis缓存中取
    List<Menu> menus = menuService.getAllMenusWithRole();
    for (Menu menu : menus) {
      if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
        List<Role> roles = menu.getRoles();
        String[] str = new String[roles.size()];
        for (int i = 0; i < roles.size(); i++) {
          str[i] = roles.get(i).getName();
        }
        return SecurityConfig.createList(str);
      }
    }
    return SecurityConfig.createList("ROLE_LOGIN");
  }

  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return Collections.emptyList();
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return true;
  }
}
