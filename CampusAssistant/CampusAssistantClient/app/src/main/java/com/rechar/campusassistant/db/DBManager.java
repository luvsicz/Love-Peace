package com.rechar.campusassistant.db;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bamboo
 * @package:com.rechar.campusassistant.db
 * @fileName:DBManager ate on:2019/11/13 17:15* @d
 */
public class DBManager extends HttpServlet {
  private static String userName; //定义的数据库用户名
  private static String passWord; //定义的数据库的连接密码
  private static String url = "mysql://36.155.102.75:3307/campus"; //数据库的Ip端口
  private static Connection connection; //定义连接
  private static String driver = "com.mysql.jdbc.Driver";
  ServletConfig config;   //定义一个ServletConfig对象

  /**
   * 获得数据库连接对象
   *
   * @return 数据库连接对象
   */
  public static Connection getConnection() {
    try {
      Class.forName(driver).newInstance();
      connection = DriverManager.getConnection(url, userName, passWord);
    } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
      Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, e);
    }
    return connection;
  }

  public static void closeAll(Connection connection, Statement statement,
                              ResultSet resultSet) {
    try {
      if (resultSet != null) {

        resultSet.close();

      }

      if (statement != null) {
        statement.close();
      }
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, e);
    }
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);    //继承父类的init()方法
    this.config = config;   //获取配置信息
    userName = config.getInitParameter("DBUsername"); // 获取数据库用户名
    passWord = config.getInitParameter("DBPassword");// 获取数据库连接密码
    url = config.getInitParameter("ConnectionURL");//获取数据库连接URL
  }
}
