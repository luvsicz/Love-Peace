package com.rechar.campusassistant.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.rechar.campusassistant.R;

/**
 * @author Bamboo
 * @package:com.rechar.campusassistant.ui+
 * @fileName:GuideFragment
 * @date on:2020/1/15 18:15
 */
public class GuideFragment extends Fragment {

  private static final String TAG = "GuideFragment";

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    Log.e(TAG, "onCreateView: ");
    View view = inflater.inflate(R.layout.guide_fragment, container, false);

    return view;
  }
}
