package org.dev.hrm.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.PrintWriter;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.RespBean;
import org.dev.hrm.service.HrService;
import org.dev.hrm.util.JackSonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  public static final String MIME = "application/json;charset=utf-8";
  @Autowired
  HrService hrService;
  @Autowired
  CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
  @Autowired
  CustomUrlDecisionManager customUrlDecisionManager;
  @Autowired
  VerificationCodeFilter verificationCodeFilter;

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(hrService);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    //不拦截的请求
    web.ignoring()
        .antMatchers("/css/**", "/js/**", "/index.html", "/img/**", "/fonts/**",
                     "/favicon.ico", "/verifyCode", "/reg", "/error",
                     "/druid/**");

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.addFilterBefore(verificationCodeFilter,
                         UsernamePasswordAuthenticationFilter.class);
    http.authorizeRequests()
        //                .anyRequest().authenticated()
        .withObjectPostProcessor(
            new ObjectPostProcessor<FilterSecurityInterceptor>() {
              @Override
              public <O extends FilterSecurityInterceptor> O postProcess(
                  O object) {
                object.setAccessDecisionManager(customUrlDecisionManager);
                object.setSecurityMetadataSource(
                    customFilterInvocationSecurityMetadataSource);
                return object;
              }
            })
        .and()
        //druid csrf
//        .csrf().ignoringAntMatchers("/druid/**")
//        .and()
        .formLogin()
        .usernameParameter("username")
        .passwordParameter("password")
        .loginProcessingUrl("/doLogin")
        //未登录泽跳转到
        .loginPage("/login")
        .successHandler((req, resp, authentication) -> {
          resp.setContentType(MIME);
          PrintWriter out = resp.getWriter();
          Hr hr = (Hr) authentication.getPrincipal();
          hr.setPassword(null);
          RespBean ok = RespBean.ok("登录成功!", hr);
          String s = new ObjectMapper().writeValueAsString(ok);
          out.write(s);
          out.flush();
          out.close();
        })
        .failureHandler((req, resp, exception) -> {
          resp.setContentType(MIME);
          PrintWriter out = resp.getWriter();
          RespBean respBean = RespBean.error("登录失败!");
          if (exception instanceof LockedException) {
            respBean.setMsg("账户被锁定，请联系管理员!");
          } else if (exception instanceof CredentialsExpiredException) {
            respBean.setMsg("密码过期，请联系管理员!");
          } else if (exception instanceof AccountExpiredException) {
            respBean.setMsg("账户过期，请联系管理员!");
          } else if (exception instanceof DisabledException) {
            respBean.setMsg("账户被禁用，请联系管理员!");
          } else if (exception instanceof BadCredentialsException) {
            respBean.setMsg("用户名或者密码输入错误，请重新输入!");
          }
          out.write(new ObjectMapper().writeValueAsString(respBean));
          out.flush();
          out.close();
        })
        .permitAll()
        .and()
        .logout()
        .logoutSuccessHandler((req, resp, authentication) -> {
          resp.setContentType(MIME);
          PrintWriter out = resp.getWriter();
          out.write(
              new ObjectMapper().writeValueAsString(RespBean.ok("注销成功!")));
          out.flush();
          out.close();
        })
        .permitAll()
        .and()
        .csrf().disable().exceptionHandling()
        //没有认证时，在这里处理结果，不要重定向
        .authenticationEntryPoint((req, resp, authException) -> {
          resp.setContentType(MIME);
          resp.setStatus(401);
          PrintWriter out = resp.getWriter();
          RespBean respBean = RespBean.error(401, "访问失败!");
          if (authException instanceof InsufficientAuthenticationException) {
            respBean.setMsg("请求失败，请联系管理员!");
          }
          out.write(new ObjectMapper().writeValueAsString(respBean));
          out.flush();
          out.close();
        })
        //处理权限不足的异常
        .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler());
  }

  @Bean
  public AccessDeniedHandler accessDeniedHandler() {
    return (request, response, accessDeniedException) -> {
      response.setContentType("text/html;charset=utf-8");
      response.getWriter().print(JackSonUtils.bean2Json(RespBean.error(403,
                                                                       "权限不足，请联系管理员")));
      response.setStatus(403);
    };
  }
}
