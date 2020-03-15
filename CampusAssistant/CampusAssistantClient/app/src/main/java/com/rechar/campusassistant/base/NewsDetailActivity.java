package com.rechar.campusassistant.base;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.rechar.campusassistant.R;
import com.rechar.campusassistant.app.AppContext;
import com.rechar.campusassistant.app.VolleyManager;
import com.rechar.campusassistant.bean.News;
import com.rechar.campusassistant.http.GsonRequest;
import com.rechar.campusassistant.ui.ViewPicActivity;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_news_detail)
public class NewsDetailActivity extends BaseActivity {
    @ViewInject(R.id.news_title)
    private TextView news_title;
    @ViewInject(R.id.news_img)
    private ImageView news_img;
    @ViewInject(R.id.news_content)
    private TextView news_content;
    @ViewInject(R.id.getdetail_progress)
    private ProgressBar getdetail_progress;
    @ViewInject(R.id.back_imageview)
    private ImageView back_imageview;
    private News news;

    private static final  String TAG="NewsDetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: " );
        x.view().inject(this);
        initData();
    }

    private void initData(){
        Log.e(TAG, "initData: " );
        int newsid = getIntent().getIntExtra("newsid",0);
        getdetail_progress.setVisibility(View.VISIBLE);
        //自定义GsonRequest
        GsonRequest<News> gsonRequest = new GsonRequest<News>(AppContext.URL_NEWS_DETAIL+"?newsid="+newsid,News.class,new Response.Listener<News>(){
            @Override
            public void onResponse(News news) {
                getdetail_progress.setVisibility(View.GONE);
                if(news!=null){
                    NewsDetailActivity.this.news = news;
                    news_title.setText(news.getTitle());
                    news_content.setText(news.getContent());
                    Picasso.with(NewsDetailActivity.this).load(AppContext.URL_SUPPRESS_PIC+news.getImg()).into(news_img);
                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                getdetail_progress.setVisibility(View.GONE);
                Toast.makeText(NewsDetailActivity.this,"获取新闻失败", Toast.LENGTH_SHORT).show();
            }
        });
        gsonRequest.setTag("getdetail");
        //添加GsonRequest至请求队列
        VolleyManager.createInstance(this).getRequestQueue().add(gsonRequest);
        //自定义XMLRequest
//        XMLRequest xmlRequest = new XMLRequest(AppContext.URL_NEWS_DETAIL + "?newsid=" + newsid + "&datatype=xml",
//                new Response.Listener<XmlPullParser>() {
//                    @Override
//                    public void onResponse(XmlPullParser response) {
//                        getdetail_progress.setVisibility(View.GONE);
//                        News news = null;
//                        try {
//                            int eventType = response.getEventType();
//                            while (eventType != XmlPullParser.END_DOCUMENT) {
//                                switch (eventType) {
//                                    case XmlPullParser.START_TAG:
//                                        String nodeName = response.getName();
//                                        if ("News".equals(nodeName)) {
//                                            news =  new News();
//                                        }
//                                        if("newsid".equals(nodeName)){
//                                            news.setNewsid(Integer.parseInt(response.nextText()));
//                                        }
//                                        if("title".equals(nodeName)){
//                                            news.setTitle(response.nextText());
//                                        }
//                                        if("content".equals(nodeName)){
//                                            news.setContent(response.nextText());
//                                        }
//                                        if("img".equals(nodeName)){
//                                            news.setImg(response.nextText());
//                                        }
//
//                                        break;
//                                    case XmlPullParser.END_TAG:
//
//                                        break;
//                                }
//                                eventType = response.next();
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        news_title.setText(news.getTitle());
//                        news_content.setText(news.getContent());
//                        Picasso.with(NewsDetailActivity.this).load(AppContext.URL_SUPPRESS_PIC+news.getImg()).into(news_img);
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        getdetail_progress.setVisibility(View.GONE);
//                        Toast.makeText(NewsDetailActivity.this,"获取新闻失败",Toast.LENGTH_SHORT).show();
//                    }
//                });
//        VolleyManager.createInstance(this).getRequestQueue().add(xmlRequest);
    }


    /**
     * 跳转到查看大图界面
     * @param view
     */
    @Event(value = R.id.news_img,type = View.OnClickListener.class)
    private void imageClick(View view){
        Intent intent = new Intent(this, ViewPicActivity.class);
        intent.putExtra("img",news.getImg());
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
        VolleyManager.createInstance(this).getRequestQueue().cancelAll("getdetail");
    }

    @Event(value = R.id.back_imageview,type = View.OnClickListener.class)
      private void backClick(View view){
        finish();
    }
}
