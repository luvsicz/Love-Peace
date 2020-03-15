package com.rechar.campusassistant.base;



import android.app.Activity;

import android.os.Bundle;

import org.xutils.x;

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
}

