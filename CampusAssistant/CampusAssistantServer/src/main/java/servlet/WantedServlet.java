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
    String result = null;
    try {
      result = getWantedNews();
      response.getWriter().print(result);
    } catch (SQLException e) {

    }
  }

  private String getWantedNews() throws SQLException {
    return (new Gson()).toJson(DBUtils.query("select * from wanted"));
  }
}
