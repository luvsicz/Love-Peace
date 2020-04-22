package com.rechar.campusassistant.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rechar.campusassistant.R;

/**
 * Created by bamboo on 2020/4/22.
 **/
public class AboutFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      return   inflater.inflate(R.layout.about_fragment, container, false);
    }

}
