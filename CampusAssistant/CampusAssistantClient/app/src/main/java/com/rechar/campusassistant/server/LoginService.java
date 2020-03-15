package com.rechar.campusassistant.server;

import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginService {
    private static final String TAG="LoginService";

    private static String ip="liurechar.utools.club";
    //通过get 的方式获取http数据
    public static String executeHttpGet(String username, String password)
    {

        Log.e(TAG, "executeHttpGet: username:"+username+" password:"+password );
        HttpURLConnection conn=null;
        InputStream is=null;
        BufferedReader reader=null;
        try {

            String  path="https://"+ip+"/UserServlet";
            Log.e(TAG, "executeHttpGet: 1:"+path );
            path=path+"?username="+username+"&password"+password;
            Log.e(TAG, "executeHttpGet: 2:"+path );
            conn=(HttpURLConnection)new URL(path).openConnection();
            conn.setRequestMethod("GET");
            Log.e(TAG, "executeHttpGet: 3" );
            conn.setConnectTimeout(3000);//设置超时时间
            Log.e(TAG, "executeHttpGet: 4" );
            conn.setReadTimeout(3000);
            Log.e(TAG, "executeHttpGet: 5" );
            conn.setDoInput(true);
            Log.e(TAG, "executeHttpGet: 7" );
            Log.e(TAG, "executeHttpGet: 8" );
            conn.setRequestProperty("Charset","UTF-8");
            Log.e(TAG, "executeHttpGet: 9" );

            if (conn.getResponseCode()==200)
            {
              //  Log.e(TAG, "executeHttpGet: 6  " +is);
                is=conn.getInputStream();
                reader=new BufferedReader(new InputStreamReader(is));
                StringBuilder response=new StringBuilder();
                String line;
                while ((line=reader.readLine())!=null)
                {
                    response.append(line);
                }
                Log.e(TAG, "executeHttpGet: 111 : "+response.toString() );

             //   return parse(is);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn!=null)
            {
                Log.e(TAG, "executeHttpGet: 10" );
                conn.disconnect();
            }
            if (reader!=null)
            {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null)
            {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return username;
    }
//将输入流转化为String 类型
    private static String parse(InputStream inputStream) throws Exception {
        Log.e(TAG, "parse: " );
        byte[] data=read(inputStream);
        Log.e(TAG, "parse: data "+new String(data,"UTF-8"));
        return new String(data,"UTF-8");
    }

//将输入流转化为byte类型

    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        inStream.close();
        return outputStream.toByteArray();
    }
}
