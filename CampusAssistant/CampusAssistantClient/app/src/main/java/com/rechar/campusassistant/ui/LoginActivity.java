package com.rechar.campusassistant.ui;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rechar.campusassistant.MainActivity;
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.server.LoginServer;


public class LoginActivity extends AppCompatActivity {

  private static String TAG = "LoginActivity";
  String userName;
  String passWord;
  private EditText etUsername;
  private EditText etPassword;
  private Button btGo;
  private CardView cv;
  private FloatingActionButton fab;

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

  private void setListener() {
    btGo.setOnClickListener(view ->  {

        userName = etUsername.getText().toString();
        passWord = etPassword.getText().toString();
        if (userName == null || userName.equals("") || passWord == null || passWord.equals("")) {
          Toast.makeText(LoginActivity.this, "用户名或密码不能为空",
                  Toast.LENGTH_SHORT).show();
        }
        final String response = LoginServer.loginByGet(userName, passWord);
        if (response == null) {
          Log.e(TAG, "onClick: 请求失败");

        } else {
          Log.e(TAG, "onClick:" + response);
          Explode explode = new Explode();
          explode.setDuration(500);

          getWindow().setExitTransition(explode);
          getWindow().setEnterTransition(explode);
          ActivityOptionsCompat oc2 =
                  ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);
          Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
          startActivity(i2, oc2.toBundle());
        }


    });
    fab.setOnClickListener(view ->  {
        getWindow().setExitTransition(null);
        getWindow().setEnterTransition(null);
        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, fab, fab.getTransitionName());
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class),
                options.toBundle());

    });
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
