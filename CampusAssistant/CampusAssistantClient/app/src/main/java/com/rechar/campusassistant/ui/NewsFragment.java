package com.rechar.campusassistant.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.gxz.PagerSlidingTabStrip;
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.adapter.SectionsPagerAdapter;

import java.util.ArrayList;

/**
 * @author Bamboo
 * @package:com.rechar.campusassistant.ui
 * @fileName:NewsFragment
 * @date on:2020/1/15 13:55
 */
public class NewsFragment extends Fragment {
    private static final String TAG="NewsFragment";
    PagerSlidingTabStrip tabs;
   ViewPager pager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.news_fragment,container,false);
        Log.e(TAG, "onCreateView: " );
        pager = (ViewPager) view.findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        //初始化Tab名称
        ArrayList<String> titles = new ArrayList<>();
        titles.add(getString(R.string.tab_text_1));
      //  titles.add(getString(R.string.tab_text_2));
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (String s : titles) {
            Bundle bundle = new Bundle();
            bundle.putString("title", s);
            //设置各类型新闻对应的Fragment
            Log.e(TAG, "onCreateView: "+ s);
            fragments.add(CapWeb.getInstance(bundle));
        }
        //设置ViewPager
        pager.setAdapter(new SectionsPagerAdapter(getActivity().getSupportFragmentManager(), titles, fragments));
        //绑定PagerSlidingTabStrip和ViewPager
        tabs.setViewPager(pager);
        //设置ViewPager当前页
        pager.setCurrentItem(0);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach: " );
    }
}
