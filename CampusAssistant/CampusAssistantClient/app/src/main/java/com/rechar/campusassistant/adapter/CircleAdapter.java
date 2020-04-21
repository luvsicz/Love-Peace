package com.rechar.campusassistant.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.model.CircleFriends;
import java.util.ArrayList;

/**
 * create by bamboo time 2020/4/5
 */
public class CircleAdapter extends BaseAdapter {

  private static final String TAG="CircleAdapter";
  private ArrayList<CircleFriends> circleList;
  private LayoutInflater mInflater;
  private Context mContext;

  public CircleAdapter( Context context, ArrayList<CircleFriends> circle_List) {
    mInflater = LayoutInflater.from(context);
    mContext = context;
    circleList = circle_List;
  }

  @Override
  public int getCount() {
    return circleList.size();
  }
  @Override
  public Object getItem(int position) {
    return circleList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }


  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    Log.e(TAG, "getView: " +position+"\n"+convertView+"\n"+ parent);
    ViewHolder holder = null;
    if (convertView == null) {
      holder = new ViewHolder();
      Log.e(TAG, "getView: " );
      convertView = mInflater.inflate(R.layout.circle_friends_item, null);
      holder.userid = (TextView) convertView.findViewById(R.id.userid);
      holder.content = (TextView) convertView.findViewById(R.id.content);
      holder.postDate=convertView.findViewById(R.id.post_date);
      holder.userid.setCursorVisible(false);
      holder.content.setCursorVisible(false);
      holder.postDate.setCursorVisible(false);
      holder.userid.setFocusable(false);
      holder.content.setFocusable(false);
      holder.postDate.setFocusable(false);
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }
    CircleFriends circleFriends = circleList.get(position);
    holder.userid.setText(circleFriends.getUserName());
    holder.content.setText(circleFriends.getContent());
    holder.postDate.setText(circleFriends.getPostDate());
    return convertView;
  }
  public final class ViewHolder {
    TextView userid;
    TextView content;
    TextView postDate;
  }
}
