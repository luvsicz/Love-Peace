package servlet;

import net.sf.json.JSONObject;
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
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/CommentsDelete")
public class CommentsDeleteServlet extends HttpServlet {

    private final static long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String content = jsonObj.getString("content");
        int code = 0;
        try {
            code = delete(username, content);
        } catch (SQLException throwables) {
            code = 500;
        }
        PrintWriter out = response.getWriter();
        System.out.println("ceode: " + code);
        out.print(code);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    private int delete(String username, String content) throws SQLException {
        Map condi = new HashMap<String, String>();
        condi.put("username", username);
        condi.put("content", content);
        int affe = DBUtils.delete("comments", condi);
        return 1 == affe ? 200 : 500;
    }
}
