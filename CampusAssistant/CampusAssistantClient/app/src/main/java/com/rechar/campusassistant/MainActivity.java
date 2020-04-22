package com.rechar.campusassistant;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rechar.campusassistant.ui.ActivitysFragment;
import com.rechar.campusassistant.ui.NewsFragment;
import com.rechar.campusassistant.ui.CricleFragment;
import com.rechar.campusassistant.widget.CanaroTextView;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity  {

    private static final long RIPPLE_DURATION = 250;
    private static final String TAG = "MainActivity";
    Toolbar toolbar;
    FrameLayout root;
    FrameLayout container_fragment;
    View contentHamburger;
    View contentNews;
    CanaroTextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        Log.e(TAG, "onCreate: ");
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        root = findViewById(R.id.root);
        container_fragment = findViewById(R.id.container_fragment);
        /**
         * toolbar：目录
         * contentHamburger:内容
         */
        title = findViewById(R.id.title);
        contentHamburger = findViewById(R.id.content_hamburger);
        contentNews = findViewById(R.id.content_news);
        //弹出的菜单
        final View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        LinearLayout profile = guillotineMenu.findViewById(R.id.profile_group);
        LinearLayout feed = guillotineMenu.findViewById(R.id.feed_group);
        LinearLayout activity = guillotineMenu.findViewById(R.id.activity_group);
        LinearLayout settings = guillotineMenu.findViewById(R.id.settings_group);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_fragment, new NewsFragment());
        transaction.commit();
        root.addView(guillotineMenu);
        // 添加弹出的菜单
        //GuillotineBuilder的第一个参数为菜单的View,第二个参数为关闭菜单的View也就是菜单布局中的按钮,第三个参数为打开菜单的View也就是主页面中的按钮
        GuillotineAnimation animation = new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .build();
        profile.setOnClickListener((v)-> {
                animation.close();
                title.setText(getString(R.string.news));
               FragmentManager managerProfile = getSupportFragmentManager();
                FragmentTransaction transactionProfile = managerProfile.beginTransaction();
              transactionProfile.replace(R.id.container_fragment, new NewsFragment());
              transactionProfile.commit();
        });
        feed.setOnClickListener((v)-> {
                animation.close();
                title.setText(getString(R.string.guide));
                FragmentManager managerFeed = getSupportFragmentManager();
                FragmentTransaction transactionFeed = managerFeed.beginTransaction();
            transactionFeed.replace(R.id.container_fragment, new CricleFragment());
            transactionFeed.commit();
        });
        activity.setOnClickListener((v)-> {
                animation.close();
                title.setText(getString(R.string.activity));
                FragmentManager managerActivity = getSupportFragmentManager();
                FragmentTransaction transactionActivity = managerActivity.beginTransaction();
                transactionActivity.replace(R.id.container_fragment, new ActivitysFragment());
                transactionActivity.commit();

        });
        settings.setOnClickListener((v)-> {
                animation.close();
                title.setText(getString(R.string.settings));
        });
        animation.close();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG, "onResume: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

//声明一个全局布尔值,默认为false
    public boolean isExit = false;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            //调用exit()方法
            exit();
        }
        return true;
    }
    //被调用的exit()方法
    private void exit() {
        Timer timer;//声明一个定时器
        if (!isExit) {  //如果isExit为false,执行下面代码
            isExit = true;  //改变值为true
            Toast.makeText(MainActivity.this, getString(R.string.exit), Toast.LENGTH_SHORT).show();  //弹出提示
            timer = new Timer();  //得到定时器对象
            //执行定时任务,两秒内如果没有再次按下,把isExit值恢复为false,再次按下返回键时依然会进入if这段代码
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);
        } else {//如果两秒内再次按下了返回键,这时isExit的值已经在第一次按下时赋值为true了,因此不会进入if后的代码,直接执行下面的代码
            finish();
        }
    }

}
