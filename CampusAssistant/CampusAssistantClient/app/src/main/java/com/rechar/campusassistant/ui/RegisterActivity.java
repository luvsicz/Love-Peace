package com.rechar.campusassistant.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.rechar.campusassistant.R;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RegisterActivity extends AppCompatActivity {

    private static String ip = "liurechar.utools.club";
    public String CREATE_ACCOUNT_URL = "https://" + ip + "/RegisterServlet";
    public static final int MSG_CREATE_RESULT = 1;
    private FloatingActionButton fab;
    private CardView cvAdd;
    private ProgressDialog progress;
    private Button bt_go;
    private EditText rg_username;
    private EditText rg_password;
    private EditText rgre_password;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_CREATE_RESULT:
                    progress.dismiss();
                    JSONObject json = (JSONObject) msg.obj;
                    hanleCreateAccountResult(json);
                    break;
            }
        }
    };


    private void hanleCreateAccountResult(JSONObject json) {
        /*
         *   result_code:
         * 0  注册成功
         * 1  用户名已存在
         * 2 数据库操作异常
         * */
        int result;
        try {
            result = json.getInt("result_code");
        } catch (JSONException e) {
            Toast.makeText(this, "没有获取到网络的响应！", Toast.LENGTH_LONG).show();
            e.printStackTrace();
            progress.dismiss();
            return;
        }

        if (result == 1) {
            Toast.makeText(this, "用户名已存在！", Toast.LENGTH_LONG).show();
            progress.dismiss();
            return;
        }

        if (result == 2) {
            Toast.makeText(this, "注册失败！服务端出现异常！", Toast.LENGTH_LONG).show();
            progress.dismiss();
            return;
        }

        if (result == 0) {
            Toast.makeText(this, "注册成功！前往登陆界面！", Toast.LENGTH_LONG).show();
            progress.dismiss();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

    }

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
        bt_go = findViewById(R.id.bt_go);
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
            Toast.makeText(this, "用户名不正确，请重新输入", Toast.LENGTH_LONG).show();
            return;
        }

        int pwdResult = checkPassword();
        if (pwdResult == 1) {
            Toast.makeText(this, "两次输入的密码不一致，请确认！", Toast.LENGTH_LONG).show();
            return;
        }
        if (pwdResult == 2) {
            Toast.makeText(this, "密码不能为空！", Toast.LENGTH_LONG).show();
            return;
        }
        createAccount();
    }

    private void createAccount() {
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setCanceledOnTouchOutside(false);
        progress.show(this, null, "注册中...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("bamboo", "Start Network!");
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(CREATE_ACCOUNT_URL);
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", rg_username.getText().toString()));
                params.add(new BasicNameValuePair("password", rg_password.getText().toString()));
                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        Log.e("bamboo", "Network OK!");
                        HttpEntity entity = httpResponse.getEntity();
                        String entityStr = EntityUtils.toString(entity);
                        String jsonStr = entityStr.substring(entityStr.indexOf("{"));
                        JSONObject json = new JSONObject(jsonStr);
                        sendMessage(MSG_CREATE_RESULT, json);

                    }
                } catch (ClientProtocolException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
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
        if (TextUtils.isEmpty(username)) {
            return false;
        }
        return true;
    }

    private void sendMessage(int what, Object obj) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        mHandler.sendMessage(msg);
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
