package com.rechar.campusassistant.ui;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.rechar.campusassistant.MainActivity;
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.util.DBHelper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginActivity extends AppCompatActivity {

  public static final int MSG_LOGIN_RESULT = 0;
  private static String TAG = "LoginActivity";
  private static String ip = "liurechar.utools.club";
  public String serverUrl = "https://" + ip + "/UserServlet";
  //返回的数据
  String info = null;
  int resultCode = -1;
  private String userName;
  private String passWord;
  private EditText etUsername;
  private EditText etPassword;
  private Button btGo;
  private CardView cv;
  private FloatingActionButton fab;
  //创建等待框
  private ProgressDialog dialog;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_activity);
    initView();
    setListener();

  }

  private void initView() {
    etUsername = findViewById(R.id.et_username);
    etPassword = findViewById(R.id.et_password);
    btGo = findViewById(R.id.bt_go);
    cv = findViewById(R.id.cv);
    fab = findViewById(R.id.fab);
  }

  @RequiresApi(api = Build.VERSION_CODES.M)
  private void setListener() {
    Log.e(TAG, "setListener: ");
    btGo.setOnClickListener(view -> {
      userName = etUsername.getText().toString();
      passWord = etPassword.getText().toString();
      if (userName == null || userName.equals("") || passWord.equals("")) {
        Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
      }
      else {
        handleLogin();
      }

    });
    fab.setOnClickListener(view -> {
      getWindow().setExitTransition(null);
      getWindow().setEnterTransition(null);
      ActivityOptions options =
          ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, fab, fab.getTransitionName());
      startActivity(new Intent(LoginActivity.this, RegisterActivity.class),
          options.toBundle());

    });
  }

  private void handleLogin() {
    String username = etUsername.getText().toString();
    String password = etPassword.getText().toString();
    login(username, password);
  }
  private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
  private final OkHttpClient mOkHttpClient = new OkHttpClient();
  private void login(final String username, final String password) {

    new Thread(new Runnable() {
      @Override
      public void run() {
        HashMap<String, String> params = new HashMap<>();
        params.put("username",username  );
        params.put("password", password);
        Gson gson = new Gson();
        //使用Gson将对象转换为json字符串
        String json = gson.toJson(params);
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(serverUrl)
                .post(body)
                .build();
        Response response = null;
        try {
          response = mOkHttpClient.newCall(request).execute();
          String str = null;
          if (response.isSuccessful()) {
            Log.e(TAG, "isSuccessful: " );
            if (response.body() != null) {
              str = response.body().string();
              Log.e(TAG, "str: " + str);
            }
          if (str.equals("200"))
          {
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                Log.e(TAG, "ok" );
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                //清空用户表
                DBHelper dbHelper=new DBHelper(LoginActivity.this,"user.db",null,1);
                dbHelper.execSQL("delete from users");
                dbHelper.execSQL("insert into users(username,password) values(?,?)",new Object[]{username,password});
//                 Cursor cursor1=dbHelper.query("select last_insert_rowid()",null);
                /*Cursor cursor1=dbHelper.query("select last_insert_rowid()",null);
                Log.e(TAG, "onLoginSuccess: "+cursor1.moveToFirst());
                if (cursor1!=null&&cursor1.moveToFirst()) {
                  Log.e(TAG, "onLoginSuccess: 1111");
                  String id=cursor1.getString(0);
                Log.e(TAG, "onLoginSuccess "+id);
              }*/


                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);
                Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i2, oc2.toBundle());
              }
            });
          }
            else  {
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                Toast.makeText(LoginActivity.this, "用户名或密码不正确", Toast.LENGTH_SHORT).show();
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

  @SuppressLint("RestrictedApi")
  @Override
  protected void onRestart() {
    super.onRestart();
    fab.setVisibility(View.GONE);
  }

  @SuppressLint("RestrictedApi")
  @Override
  protected void onResume() {
    super.onResume();
    fab.setVisibility(View.VISIBLE);
  }

}



