package com.rechar.campusassistant.ui;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alexvasilkov.android.commons.adapters.ItemsAdapter;
import com.alexvasilkov.android.commons.ui.Views;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.adapter.NewsAdapter;
import com.rechar.campusassistant.app.AppContext;
import com.rechar.campusassistant.app.VolleyManager;
import com.rechar.campusassistant.base.NewsDetailActivity;
import com.rechar.campusassistant.bean.News;

import com.rechar.campusassistant.util.NetUtil;

import org.litepal.crud.DataSupport;
import org.xutils.common.util.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.srain.cube.util.LocalDisplay;
import in.srain.cube.views.loadmore.LoadMoreContainer;
import in.srain.cube.views.loadmore.LoadMoreHandler;
import in.srain.cube.views.loadmore.LoadMoreListViewContainer;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String TAG="PlaceholderFragment";
    private List<News> newslist = new ArrayList<>();
    private NewsAdapter adapter;
    private String type;
    private int startid = 0;
    private int count = 5;
    private boolean flag = false;

    private static class ViewHolder {
        PtrFrameLayout mPtrFrameLayout;
        LoadMoreListViewContainer mLoadMoreListViewContainer;
        ListView mListView;
    }

    private ViewHolder mViewHolder;

    public static Fragment getInstance(Bundle bundle) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Log.e(TAG, "getInstance:bundle: "+bundle );
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: " );
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.i("Fragment onCreateView");

        View view = inflater.inflate(R.layout.news_container_fragment, container, false);
        Log.e(TAG, "onCreateView: ");
        //获取当前Fragment所需加载新闻类型
        Bundle bundle = getArguments();

        final String type = bundle.getString("title");

        Log.e(TAG, "onCreateView: type"+type );
                //初始化控件
        mViewHolder = new ViewHolder();
        mViewHolder.mListView = (ListView) view.findViewById(R.id.load_more_listview);
        //ListView添加点击事件，跳转到详细页面
        mViewHolder.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra("newsid", newslist.get(position-1).getNewsid());
                startActivity(intent);
            }
        });
        adapter = new NewsAdapter(newslist, getActivity());
        mViewHolder.mListView.setAdapter(adapter);
        //3.设置下拉刷新组件和事件监听
        mViewHolder.mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.load_more_list_view_ptr_frame);
        mViewHolder.mPtrFrameLayout.setLoadingMinTime(1000);
        mViewHolder.mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                // here check list view, not content.
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mViewHolder.mListView, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //实现下拉刷新的功能

                Log.e(TAG, "onRefreshBegin: " );
                newslist.clear();
                //判断网络是否可用，若无网络则加载离线新闻
                if(!NetUtil.isNetworkAvailable(getActivity())){
                    newslist = DataSupport.select("*").where("newstype=?",switchType(type)).order("newsid desc").limit(count).find(News.class);
                    if(newslist.size()>0){
                        mViewHolder.mLoadMoreListViewContainer.loadMoreFinish(false, true);
                        startid = newslist.get(newslist.size()-1).getNewsid();
                    }else{
                        mViewHolder.mLoadMoreListViewContainer.loadMoreFinish(true, false);
                    }
                    adapter.setNewList(newslist);
                }else{
                    //创建请求
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, AppContext.URL_GETNEWS, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (!TextUtils.isEmpty(response)) {
                                Gson gson = new Gson();
                                newslist = gson.fromJson(response, new TypeToken<List<News>>() {
                                }.getType());
                                if(newslist.size()>0){
                                    mViewHolder.mLoadMoreListViewContainer.loadMoreFinish(false, true);
                                    startid = newslist.get(newslist.size()-1).getNewsid();
                                }else{
                                    mViewHolder.mLoadMoreListViewContainer.loadMoreFinish(true, false);
                                }
                                adapter.setNewList(newslist);
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> map = new HashMap<String, String>();
                            Log.e(TAG, "getParams: num:"+ count+" newstype:"+type);
                            map.put("pagenum", "1");
                            map.put("num", String.valueOf(count));
                            map.put("newstype", switchType(type));
                            return map;
                        }
                    };
                    //TODO将请求添加到请求队列
                    Log.e(TAG, "onRefreshBegin: 1" );
                    VolleyManager volleyManager = VolleyManager.createInstance(getActivity());
                    volleyManager.getRequestQueue().add(stringRequest);
                }
                mViewHolder.mPtrFrameLayout.refreshComplete();
            }


        });

        //4.加载更多的组件
        // 为listview的创建一个headerview,注意，如果不加会影响到加载的footview的显示！
        View headerMarginView = new View(getActivity());
        headerMarginView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LocalDisplay.dp2px(20)));
        mViewHolder.mListView.addHeaderView(headerMarginView);
        mViewHolder.mLoadMoreListViewContainer = (LoadMoreListViewContainer) view.findViewById(R.id.load_more_list_view_container);
        mViewHolder.mLoadMoreListViewContainer.useDefaultHeader();
        //5.添加加载更多的事件监听
        mViewHolder.mLoadMoreListViewContainer.setLoadMoreHandler(new LoadMoreHandler() {
            @Override
            public void onLoadMore(LoadMoreContainer loadMoreContainer) {
                mViewHolder.mLoadMoreListViewContainer.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!NetUtil.isNetworkAvailable(getActivity())){
                            List<News> list = DataSupport.select("*").where("newstype=? and newsid<"+startid,switchType(type)).order("newsid desc").limit(count).find(News.class);
                            if (list != null && list.size() > 0) {
                                startid = list.get(list.size() - 1).getNewsid();
                                newslist.addAll(list);
                                adapter.setNewList(newslist);
                                mViewHolder.mLoadMoreListViewContainer.loadMoreFinish(false, true);
                            } else {
                                int errorCode = 0;
                                String errormessage = "没有更多数据，点击加载更多";
                                mViewHolder.mLoadMoreListViewContainer.loadMoreError(errorCode, errormessage);
                            }
                        }else{
                            StringRequest stringRequest = new StringRequest(Request.Method.POST, AppContext.URL_GETNEXTNEWS, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    if (!TextUtils.isEmpty(response)) {
                                        Gson gson = new Gson();
                                        List<News> list = gson.fromJson(response, new TypeToken<List<News>>() {
                                        }.getType());
                                        if (list != null && list.size() > 0) {
                                            startid = list.get(list.size() - 1).getNewsid();
                                            newslist.addAll(list);
                                            adapter.setNewList(newslist);
                                            mViewHolder.mLoadMoreListViewContainer.loadMoreFinish(false, true);
                                        } else {
//                                            int errorCode = 0;
////                                            String errormessage = "没有更多数据，点击加载更多";
////                                            mViewHolder.mLoadMoreListViewContainer.loadMoreError(errorCode, errormessage);
                                            mViewHolder.mLoadMoreListViewContainer.loadMoreFinish(true, false);
                                        }
                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }) {
                                @Override
                                protected Map<String, String> getParams() {
                                    Map<String, String> map = new HashMap<>();
                                    map.put("newsid", String.valueOf(startid));
                                    map.put("newstype", switchType(type));
                                    return map;
                                }
                            };
                            VolleyManager.createInstance(getActivity()).getRequestQueue().add(stringRequest);
                        }
                    }
                }, 1000);


//                        adapter.notifyDataSetChanged();
            }
        });
//        StringRequest stringRequest1 = new StringRequest(Request.Method.GET,AppContext.URL_GETNEWS,new Response.Listener<String>(){
//            @Override
//            public void onResponse(String response) {
//
//            }
//        },new Response.ErrorListener(){
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
        //设置延时自动刷新数据
        mViewHolder.mPtrFrameLayout.postDelayed(()-> {
                Log.e(TAG, "run:设置延时自动刷新数据 " );
                mViewHolder.mPtrFrameLayout.autoRefresh(false);
        }, 200);
        return view;
    }

    /**
     * 将新闻类型参数转换为服务端需要的格式
     *
     * @param type
     * @return
     */
    public String switchType(String type) {
        Log.e(TAG, "switchType: "+type );
        if (TextUtils.equals(getString(R.string.tab_text_1), type)) {
            Log.e(TAG, "switchType:1 " );
            return "1";
        }else {
            Log.e(TAG, "switchType:2 " );
            return "2";
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach: " );
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach: " );
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "Fragment pause: " );
        LogUtil.i("Fragment pause");
    }

    public void test(){
        ContentValues values = new ContentValues();
        values.put("title", "明天将会下雨");
        DataSupport.updateAll(News.class, values, "title = ? and newstype = ?", "明天是晴天", "1");
        DataSupport.deleteAll(News.class, "title = ?", "今天将会下雨");
    }

}