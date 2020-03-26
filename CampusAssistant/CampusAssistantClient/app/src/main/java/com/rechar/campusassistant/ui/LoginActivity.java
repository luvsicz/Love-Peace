package com.rechar.campusassistant.ui;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
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
import com.rechar.campusassistant.MainActivity;
import com.rechar.campusassistant.R;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
  //返回主线程更新数据
  private Handler logHandler;
  private Handler mHandler = new Handler() {
    public void handleMessage(Message msg) {
      switch (msg.what) {
        case MSG_LOGIN_RESULT:
          Log.e(TAG, "handleMessage: 1  " + msg.obj);
          JSONObject json = (JSONObject) msg.obj;
          Log.e(TAG, "handleMessage:2   " + json);
          handleLoginResult(json);
          break;
      }
    }

  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_activity);

    logHandler = new Handler();
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
      if (userName == null || userName.equals("") || passWord == null || passWord.equals("")) {
        Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
      }
         /*  else if (!checkNetWork()) {
                Log.e(TAG, "setListener: ");
                Toast toast = Toast.makeText(this, "网络未连接", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }*/

      else {
        handleLogin();
      }

    });
    fab.setOnClickListener(view -> {
      getWindow().setExitTransition(null);
      getWindow().setEnterTransition(null);
      ActivityOptions options =
          ActivityOptions
              .makeSceneTransitionAnimation(LoginActivity.this, fab, fab.getTransitionName());
      startActivity(new Intent(LoginActivity.this, RegisterActivity.class),
          options.toBundle());

    });
  }

  private void handleLogin() {
    String username = etUsername.getText().toString();
    String password = etPassword.getText().toString();
    login(username, password);
  }

  private void login(final String username, final String password) {

    new Thread(new Runnable() {
      @Override
      public void run() {
        Log.e("bamboo", "start network!");
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(serverUrl);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", password));

        HttpResponse httpResponse = null;
        try {
          httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
          httpResponse = client.execute(httpPost);
          if (httpResponse.getStatusLine().getStatusCode() == 200) {
            Log.e("bamboo", "network OK!");
            HttpEntity entity = httpResponse.getEntity();
            String entityString = EntityUtils.toString(entity);
            String jsonString = entityString.substring(entityString.indexOf("{"));
            Log.e("bamboo", "entity = " + jsonString);
            JSONObject json = new JSONObject(jsonString);
            sendMessage(MSG_LOGIN_RESULT, json);
            Log.e("bamboo", "json = " + json);
          }
        } catch (UnsupportedEncodingException e) {
          Log.e("bamboo", "UnsupportedEncodingException");
          e.printStackTrace();
        } catch (ClientProtocolException e) {
          Log.e("bamboo", "ClientProtocolException");
          e.printStackTrace();
        } catch (IOException e) {
          Log.e("bamboo", "IOException");
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (JSONException e) {
          Log.e("bamboo", "IOException");
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }).start();

  }

  private void handleLoginResult(JSONObject json) {
    /*
     * login_result:
     * -1：登陆失败，未知错误！
     * 0: 登陆成功！
     * 1：登陆失败，用户名或密码错误！
     * 2：登陆失败，用户名不存在！
     * */
    Log.e(TAG, "handleLoginResult3:  " + json);

    Log.e(TAG, "handleLoginResult: " + resultCode);
    resultCode = json.optInt("result_code");
    Log.e(TAG, "handleLoginResult4: " + resultCode);
    switch (resultCode) {
      case 0:
        Log.e(TAG, "login succ: ");
        onLoginSuccess(json);
        break;
      case 1:
        Toast.makeText(this, "用户名或密码错误！", Toast.LENGTH_LONG).show();
        break;
      case 2:
        Toast.makeText(this, "用户名不存在！", Toast.LENGTH_LONG).show();
        break;
      case -1:
      default:
        Toast.makeText(this, "登陆失败！未知错误！", Toast.LENGTH_LONG).show();
        break;
    }

  }

  private void onLoginSuccess(JSONObject json) {
    //Intent intent = new Intent(this, MainActivity.class);
        /*try {
            intent.putExtra("username", json.getString("username"));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    //  startActivity(intent);
    //  finish();
    Log.e(TAG, "onLoginSuccess: " + json);
    ActivityOptionsCompat oc2 =
        ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);
    Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
    startActivity(i2, oc2.toBundle());
  }

  private void sendMessage(int what, Object obj) {
    Message msg = Message.obtain();
    msg.what = what;
    msg.obj = obj;
    mHandler.sendMessage(msg);
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

    /*//检测网络，只能检测流量，不能检测wifi
    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean checkNetWork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetwork() != null) {
            return connectivityManager.getActiveNetworkInfo().isAvailable();
        }
        return true;
    }*/
}



