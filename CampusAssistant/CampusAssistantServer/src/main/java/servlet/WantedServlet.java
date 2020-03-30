package servlet;

import com.google.gson.Gson;
import tools.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/WantedServlet")
public class WantedServlet extends HttpServlet {

  private final static long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws IOException {
    response.setContentType("text/html; charset=UTF-8");
    //  response. header("Content-type: text/html; charset=utf-8");
//    DataOutputStream dos = new DataOutputStream(response.getOutputStream());
    String result = null;
    try {
      result = getWantedNews();
      //dos.writeUTF(result);
//      response.getWriter().write(result);
      response.getWriter().print(result);
    } catch (SQLException e) {
//      e.printStackTrace();
    }
  }

  private String getWantedNews() throws SQLException {
    HashMap<String, Object> resultMap = new HashMap<String, Object>();
//    resultMap.put("data", DBUtils.query("select * from wanted"));
    return (new Gson()).toJson(DBUtils.query("select * from wanted"));
  }
}
