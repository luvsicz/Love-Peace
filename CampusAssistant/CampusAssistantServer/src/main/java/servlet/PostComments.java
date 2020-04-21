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

@WebServlet("/PostComments")
public class PostComments extends HttpServlet {

    private final static long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (ServletInputStream) request.getInputStream(), "utf-8"));
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
        String postDate = jsonObj.getString("postDate");
        System.out.println(username + "_" + content + "_" + postDate);
        Map<String, Object> condi = new HashMap<>();
        condi.put("username", username);
        condi.put("content", content);
        condi.put("postDate", postDate);
        try {
            //插入成功返回200 插入失败返回500
            HashMap<String, Object> result = new HashMap<String, Object>();
            int counts = DBUtils.insert("comments", condi);
            System.out.println(counts);
            int code = 0;
            if (counts == 1) {
                //注册失败
                code = 200;
            } else {
                code = 500;
            }
            PrintWriter out = response.getWriter();
            System.out.println("ceode: " + code);
            out.print(code);
            // 释放PrintWriter对象
            out.flush();
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
