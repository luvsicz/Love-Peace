package com.rechar.campusassistant.server;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LoginServer {

  public static String loginByGet(String username, String password) {
    try {
      //提交数据到服务器
      //拼装路径
      String path = "http://36.155.102.75:3307/campus/UserServlet?username="
              + URLEncoder.encode(username, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8");
      URL url = new URL(path);

      HttpURLConnection conn = (HttpURLConnection) url.openConnection();//打开连接

      conn.setRequestMethod("GET");//设置请求方式为get

      conn.setConnectTimeout(5000);//设置连接超时时间为5秒

      int code = conn.getResponseCode();//获得请求码
      if (code == 200) {
        InputStream is = conn.getInputStream();
        //   String text = StreamTools.readInputStream(is);等下加---------
        //  return text;
      } else {
        return null;
      }
//            return null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


  //这里提交的路径一定要写准确，填写你当前所在局域网的ip + 项目名 + Servlet Url
  public static String loginByPost(String username, String password) {
    try {

      String path = "http://localhost:8080/user";
      URL url = new URL(path);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setConnectTimeout(8000);
      conn.setReadTimeout(8000);
      conn.setRequestMethod("POST");
      String data = "username=" + URLEncoder.encode(username) + "&password="
              + URLEncoder.encode(password);
      System.out.println(data);
      conn.setRequestProperty("Content=Type", "application/x-wwww-form" +
              "-urlencoded");
      conn.setRequestProperty("Content-length", data.length() + "");
      conn.setDoOutput(true);
      OutputStream os = conn.getOutputStream();
      os.write(data.getBytes());
      int code = conn.getResponseCode();
      if (code == 200) {
        InputStream is = conn.getInputStream();
        // String text = StreamTools.readInputStream(is);
        //return text;
      } else {
        return null;
      }

    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      Log.e(TAG, "loginByPost:11111111111111 ");

    } catch (ProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


}
