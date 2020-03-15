package com.rechar.campusassistant.server;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginServicePost {
    private static final String TAG="LoginServicePost";
    private static String ip ="liurechar.uicp.io:48663";
    public static String executeHttpPost(String username, String password) throws Exception {

        Log.e(TAG, "executeHttpPost: " );
        String  path="https://"+ip+"/UserServlet";
        //发送指令和信息
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        Log.e(TAG, "executeHttpPost: "+params );
        return sendPOSTRequest(path,params,"UTF-8");
    }
    private static String sendPOSTRequest(String path,Map<String,String>params,String encoding) throws Exception {
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        UrlEncodedFormEntity entity=new UrlEncodedFormEntity(pairs,encoding);
        HttpPost post= new HttpPost(path);
        post.setEntity(entity);
        DefaultHttpClient client=new DefaultHttpClient();
        //请求超时
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,5000);
        //读取超时
        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,5000);
        HttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode()==200)
        {
            Log.e(TAG, "sendPOSTRequest: ");
            return getInfo(response);
        }
        return null;
    }

    private static String getInfo(HttpResponse response) throws Exception {
        HttpEntity entity=response.getEntity();
        InputStream is=entity.getContent();
        //将输入流转化为byte型
        byte[]data = LoginService.read(is);
        return new String(data, "UTF-8");
    }

}
