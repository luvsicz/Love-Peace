package com.rechar.campusassistant.ui;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
import java.util.HashMap;
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
  private String userName;
  private String passWord;
  private EditText etUsername;
  private EditText etPassword;
  private Button btGo;
  private FloatingActionButton fab;
  //创建等待框
  private ProgressDialog dialog;
  private TextView visitor_login;
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
    CardView cv = findViewById(R.id.cv);
    fab = findViewById(R.id.fab);
    visitor_login=findViewById(R.id.visitor_login);
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
      ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, fab, fab.getTransitionName());
      startActivity(new Intent(LoginActivity.this, RegisterActivity.class), options.toBundle());
    });
    visitor_login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        DBHelper dbHelper=new DBHelper(LoginActivity.this,"user.db",null,1);
        dbHelper.execSQL("delete from users");
        ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);
        Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i2, oc2.toBundle());
      }
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
                Toast.makeText(LoginActivity.this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show();
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



