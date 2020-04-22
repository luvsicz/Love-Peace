package com.rechar.campusassistant.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.rechar.campusassistant.R;
import java.io.IOException;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class RegisterActivity extends AppCompatActivity {

  private static String ip = "liurechar.utools.club";
  public String CREATE_ACCOUNT_URL = "https://" + ip + "/RegisterServlet";
  private FloatingActionButton fab;
  private CardView cvAdd;
  private EditText rg_username;
  private EditText rg_password;
  private EditText rgre_password;
  private static final String TAG="RegisterActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.register_activity);
    ShowEnterAnimation();
    initView();
    fab.setOnClickListener(view -> {
      {
        animateRevealClose();
      }
    });
  }

  private void initView() {
    fab = findViewById(R.id.fab);
    cvAdd = findViewById(R.id.cv_add);
    Button bt_go = findViewById(R.id.bt_go);
    rg_username = findViewById(R.id.rg_username);
    rg_password = findViewById(R.id.rg_password);
    rgre_password = findViewById(R.id.rg_repeatpassword);
    bt_go.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        handleCreateAccount();
      }
    });
  }

  private void handleCreateAccount() {
    boolean isUsernameValid = checkUsername();
    if (!isUsernameValid) {
      Toast.makeText(this, getString(R.string.u_incor), Toast.LENGTH_LONG).show();
      return;
    }
    int pwdResult = checkPassword();
    if (pwdResult == 1) {
      Toast.makeText(this, getString(R.string.tow_input), Toast.LENGTH_LONG).show();
      return;
    }
    if (pwdResult == 2) {
      Toast.makeText(this, getString(R.string.null_password), Toast.LENGTH_LONG).show();
      return;
    }
    createAccount();
  }
  private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
  private final OkHttpClient mOkHttpClient = new OkHttpClient();
  private void createAccount() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        HashMap<String, String> params = new HashMap<>();
        params.put("username",   rg_username.getText().toString());
        params.put("password", rg_password.getText().toString());
        Gson gson = new Gson();
        //使用Gson将对象转换为json字符串
        String json = gson.toJson(params);
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
              runOnUiThread(new Runnable() {
                @Override
                public void run() {
                  Toast.makeText(RegisterActivity.this, getString(R.string.register_success), Toast.LENGTH_SHORT).show();
                }
              });
              finish();
            } else {
              runOnUiThread(new Runnable() {
                @Override
                public void run() {
                  Toast.makeText(RegisterActivity.this,getString(R.string.register_fail) , Toast.LENGTH_SHORT).show();
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

  private int checkPassword() {
    /*
     * return value:
     * 0 password valid
     * 1 password not equal 2 inputs
     * 2 password empty
     * */
    String pwd1 = rg_password.getText().toString();
    String pwd2 = rgre_password.getText().toString();
    if (!pwd1.equals(pwd2)) {
      return 1;
    } else if (TextUtils.isEmpty(pwd1)) {
      return 2;
    } else {
      return 0;
    }
  }

  private boolean checkUsername() {
    String username = rg_username.getText().toString();
    return !TextUtils.isEmpty(username);
  }

  private void ShowEnterAnimation() {
    Transition transition =
        TransitionInflater.from(this).inflateTransition(R.transition.fabtransition);
    getWindow().setSharedElementEnterTransition(transition);

    transition.addListener(new Transition.TransitionListener() {
      @Override
      public void onTransitionStart(Transition transition) {
        cvAdd.setVisibility(View.GONE);
      }

      @Override
      public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        animateRevealShow();
      }

      @Override
      public void onTransitionCancel(Transition transition) {

      }

      @Override
      public void onTransitionPause(Transition transition) {

      }

      @Override
      public void onTransitionResume(Transition transition) {

      }


    });
  }

  public void animateRevealShow() {
    Animator mAnimator = ViewAnimationUtils.createCircularReveal(cvAdd,
        cvAdd.getWidth() / 2, 0, fab.getWidth() / 2, cvAdd.getHeight());
    mAnimator.setDuration(500);
    mAnimator.setInterpolator(new AccelerateInterpolator());
    mAnimator.addListener(new AnimatorListenerAdapter() {
      @Override
      public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
      }

      @Override
      public void onAnimationStart(Animator animation) {
        cvAdd.setVisibility(View.VISIBLE);
        super.onAnimationStart(animation);
      }
    });
    mAnimator.start();
  }

  public void animateRevealClose() {
    Animator mAnimator = ViewAnimationUtils.createCircularReveal(cvAdd,
        cvAdd.getWidth() / 2, 0, cvAdd.getHeight(), fab.getWidth() / 2);
    mAnimator.setDuration(500);
    mAnimator.setInterpolator(new AccelerateInterpolator());
    mAnimator.addListener(new AnimatorListenerAdapter() {
      @Override
      public void onAnimationEnd(Animator animation) {
        cvAdd.setVisibility(View.INVISIBLE);
        super.onAnimationEnd(animation);
        fab.setImageResource(R.mipmap.plus);
        RegisterActivity.super.onBackPressed();
      }

      @Override
      public void onAnimationStart(Animator animation) {
        super.onAnimationStart(animation);
      }
    });
    mAnimator.start();
  }

  @Override
  public void onBackPressed() {
    animateRevealClose();
  }
}
