package com.rechar.campusassistant.ui;

import android.database.Cursor;
import android.net.ParseException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.util.DBHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * create by bamboo time 2020/4/5
 */
public class AddNoticeActivity extends AppCompatActivity {
    private EditText notice_post;
    private ImageButton postAllDate;
    private String CREATE_ACCOUNT_URL = "https://" + ip + "/PostComments";
    private static String ip = "liurechar.utools.club";
    private static final String TAG = "AddNoticeActivity";
    private static final int MSG_CREATE_RESULT = 1;
    String username = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_notice);
        notice_post = findViewById(R.id.notice_post);
        postAllDate = findViewById(R.id.post_alldate);
        Log.e(TAG, "onCreate:---------- " );
       // DBHelper dbHelper=new DBHelper(LoginActivity.this,"user.db",null,1);
        DBHelper dbHelper = new DBHelper(AddNoticeActivity.this, "user.db", null, 1);
      //  Cursor cursor1=dbHelper.query("select username from users where rowid=(select last_insert_rowid())",null);
        Cursor cursor1=dbHelper.query("select last_insert_rowid()",null);

        Log.e(TAG, "onCreate: "+cursor1.moveToFirst());
        if (cursor1!=null&&cursor1.moveToFirst()) {
            Log.e(TAG, "sendData: 1111");
            String id=cursor1.getString(0);
            Log.e(TAG, "hhh "+id);
        }

        postAllDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: ");
                try {
                    sendData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient mOkHttpClient = new OkHttpClient();

    private void sendData() throws IOException {
        Log.e(TAG, "sendData: ");

        // Log.e(TAG, "sendData: username: " + username);
        String content = notice_post.getText().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        String postDate = simpleDateFormat.format(date);
        // HashMap with Params:username and content
        HashMap<String, String> params = new HashMap<>();
        Log.e(TAG, "sendData: " + username);
        params.put("content", content);
        params.put("username", username);
        params.put("postDate", postDate);
        Gson gson = new Gson();
        //使用Gson将对象转换为json字符串
        String json = gson.toJson(params);
        Log.e(TAG, "sendData: " + json);
        Log.e(TAG, "sendData: " + CREATE_ACCOUNT_URL);
        new Thread(new Runnable() {
            @Override
            public void run() {
                RequestBody body = RequestBody.create(json, JSON);
                Request request = new Request.Builder()
                        .url(CREATE_ACCOUNT_URL)
                        .post(body)
                        .build();
                Response response = null;
                try {
                    response = mOkHttpClient.newCall(request).execute();
                    String str = null;
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            str = response.body().string();
                            Log.e(TAG, "str: " + str);
                        }
                        if (str.equals("200")) {
                            Log.e(TAG, "run: 发布成功");
                            finish();
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(AddNoticeActivity.this, "发布失败", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        Log.e(TAG, "sendData: " + gson.toJson(str));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
