package org.dev.hrm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dev.hrm.model.RespBean;
import org.springframework.stereotype.Component;

/**
 * @时间 2020-02-28 22:03
 */
@Component
public class VerificationCodeFilter extends GenericFilter {

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;
//    if ("POST".equals(req.getMethod()) && "/doLogin".equals(req.getServletPath())) {
//      //登录请求
//      String code = req.getParameter("code");
//      String verify_code = (String) req.getSession().getAttribute("verify_code");
//      if (code == null || verify_code == null || "".equals(code) || !verify_code.toLowerCase()
//          .equals(code.toLowerCase())) {
//        //验证码不正确
//        filterChain.doFilter(req, resp);
//        resp.setContentType("application/json;charset=utf-8");
//        PrintWriter out = resp.getWriter();
//        out.write(new ObjectMapper().writeValueAsString(RespBean.error("验证码填写错误")));
//        out.flush();
//        out.close();
//        return;
//      } else {
        filterChain.doFilter(req, resp);
//      }
//    } else {
//      filterChain.doFilter(req, resp);
//    }
  }
}
