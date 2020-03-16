package servlet;

import com.google.gson.Gson;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private final static long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // String name = request.getParameter("username");// 获取输入用户名
        // String pass = request.getParameter("password");// 获取输入密码
        response.setContentType("text/html; charset=UTF-8");
        DataOutputStream dos = new DataOutputStream(response.getOutputStream());

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String result = doLogin(username, password);
        System.out.println("result = " + result);
        dos.writeUTF(result);

    }

    private String doLogin(String username, String password) {
        /*
         * login_result:
         * -1：登陆失败，未知错误！
         * 0: 登陆成功！
         * 1：登陆失败，用户名或密码错误！
         * 2：登陆失败，用户名不存在！
         * */
        System.out.println(username + "-----" + password);
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        UserService test = new UserServiceImpl();
        User users;
        try {
            users = (User) test.checkNP(username, password);
            //   System.out.println(users.getUsername()+"password:  "+);
            if (users == null) {
                //没找到
                resultMap.put("result_code", 1);
            } else if (!password.equals(users.getPassword())) {
                //密码错误
                resultMap.put("result_code", 1);
            } else {
                //找到
                resultMap.put("result_code", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (new Gson()).toJson(resultMap);
    }
}
