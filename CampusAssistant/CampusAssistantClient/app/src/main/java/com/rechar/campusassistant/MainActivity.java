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
import com.rechar.campusassistant.ui.ActivitysFragment;
import com.rechar.campusassistant.ui.NewsFragment;
import com.rechar.campusassistant.ui.CricleFragment;
import com.rechar.campusassistant.widget.CanaroTextView;
import com.yalantis.guillotine.animation.GuillotineAnimation;

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
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.sure_exit));
            builder.setTitle(getString(R.string.tip));
            builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    // TODO Auto-generated method stub
                    arg0.dismiss();
                }
            });

            builder.setPositiveButton(getString(R.string.exit), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.create().show();
        }
        return true;
    }
}
