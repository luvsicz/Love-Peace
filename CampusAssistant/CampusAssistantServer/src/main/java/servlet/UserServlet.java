package servlet;

import com.google.gson.Gson;
import entity.User;
import net.sf.json.JSONObject;
import service.UserService;
import service.impl.UserServiceImpl;
import tools.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private final static long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  response.setContentType("text/html; charset=UTF-8");
        DataOutputStream dos = new DataOutputStream(response.getOutputStream());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String result = doLogin(username, password);
        System.out.println("result = " + result);
        dos.writeUTF(result);*/





        response.setContentType("text/html; charset=UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer("");
        String temp;
        while ((temp = br.readLine()) != null) {
            sb.append(temp);
        }
        br.close();
        //获取到的json字符串
        String acceptjson = sb.toString();
        //将json字符串转为jsonobject对象
        System.out.println("acceptjson:" + acceptjson);
        //转JSONObject对象
        JSONObject jsonObj;
        jsonObj = JSONObject.fromObject(acceptjson);
        //将jsonobject对象转为java对象
        System.out.println("json:" + jsonObj);
        String username = jsonObj.getString("username");
        String password = jsonObj.getString("password");
        System.out.println(username + "_" + password );
        Map<String, Object> condi = new HashMap<>();
        condi.put("username", username);
        condi.put("password", password);
        UserService test = new UserServiceImpl();
        User users;
        User user;
        int code = 0;
        List<Map < String, Object>> counts;
        try {
            counts= DBUtils.query("user",condi);
           // users = (User) test.checkNP(username, password);
            if (counts.isEmpty()) {
                //用户名错误或密码错误
                code=500;
            }  else {
                //找到
                code=200;
            }
            PrintWriter out = response.getWriter();
            System.out.println("ceode: " + code);
            out.print(code);
            // 释放PrintWriter对象
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


















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
                //悄悄地来了 悄悄地走了
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (new Gson()).toJson(resultMap);
    }
}
