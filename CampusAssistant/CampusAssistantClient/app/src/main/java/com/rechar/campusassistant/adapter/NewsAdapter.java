package com.rechar.campusassistant.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rechar.campusassistant.R;
import com.rechar.campusassistant.app.AppContext;
import com.rechar.campusassistant.bean.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private List<News> newslist;
    private Context context;

    public NewsAdapter(List<News> newslist, Context context) {
        this.newslist = newslist;
        this.context = context;
    }

    public void setNewList(List<News> newslist){
        this.newslist = newslist;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return newslist.size();
    }

    @Override
    public Object getItem(int position) {
        return newslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.news_item,null);
            viewHolder.news_pic = (ImageView) convertView.findViewById(R.id.news_pic);
            viewHolder.news_title = (TextView) convertView.findViewById(R.id.news_title);
            viewHolder.news_content = (TextView) convertView.findViewById(R.id.news_content);
            viewHolder.pdate = (TextView) convertView.findViewById(R.id.pdate);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.news_title.setText(newslist.get(position).getTitle());
        viewHolder.news_content.setText(newslist.get(position).getContent());
        viewHolder.pdate.setText(newslist.get(position).getPdate());
        //TODO 加载缓存图片
        Picasso.with(context)
                //设置图片URL
                .load(AppContext.URL_SUPPRESS_PIC+newslist.get(position).getImg())
                //设置图片宽高
                .resize(75,75)
                //设置图片显示方式
                .centerCrop()
                //设置加载过程中显示图片
                .placeholder(R.mipmap.base_list_default_icon)
                //设置加载错误图片
                .error(R.mipmap.base_list_default_icon)
                //设置需要加载的ImageView
                .into(viewHolder.news_pic);
        return convertView;
    }

    public class ViewHolder{
        ImageView news_pic;
        TextView news_title;
        TextView news_content;
        TextView pdate;
    }
}
