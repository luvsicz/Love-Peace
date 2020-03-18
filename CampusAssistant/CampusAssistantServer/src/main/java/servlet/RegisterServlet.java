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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        //request.setCharacterEncoding("UTF-8");
        DataOutputStream dos = new DataOutputStream(response.getOutputStream());
        HashMap<String, Object> params = getParamsFromRequest(request);
        String result = handleNewUser(params);
        dos.writeUTF(result);
    }

    private String handleNewUser(HashMap<String, Object> params) {
        /*
         *   result_code:
         * 0 用户名不存在，可以正常注册
         * 1  用户名已存在
         * 2 数据库操作异常
         * */
        HashMap<String, Object> result = new HashMap<String, Object>();
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        System.out.println(username + "_" + password);
        UserService test = new UserServiceImpl();
        User users;
        try {
            users = (User) test.checkName(username);
            if (users != null) {
                //不可插入
                result.put("result_code", 1);
            } else {
                int counts = test.register(username, password);
                if (counts == 0) {
                    //注册失败
                    result.put("result_code", 2);
                } else {
                    //chengg
                    result.put("result_code", 0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (new Gson()).toJson(result);
    }

    HashMap<String, Object> getParamsFromRequest(HttpServletRequest request) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("username", request.getParameter("username"));
        params.put("password", request.getParameter("password"));
        return params;
    }

}
