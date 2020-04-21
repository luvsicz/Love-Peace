package com.rechar.campusassistant.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alexvasilkov.android.commons.adapters.ItemsAdapter;
import com.alexvasilkov.android.commons.ui.Views;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rechar.campusassistant.R;
import com.rechar.campusassistant.model.Painting;
import com.rechar.campusassistant.ui.ActivitysFragment;
import com.rechar.campusassistant.util.GlideHelper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 主界面adapter,获取列表封面/title TOUCH监听进入另一个view(内部) 可接收
 */
public class PaintingsAdapter extends ItemsAdapter<Painting, PaintingsAdapter.ViewHolder> implements
    View.OnClickListener {
    private static final String TAG = "PaintingsAdapter";
    private String CREATE_ACCOUNT_URL = "https://" + ip + "/WantedServlet";
    private static String ip = "liurechar.utools.club";
    private Activity activity;
    private List<Painting> paintingList = null;

    public PaintingsAdapter(Context context) {
        Log.e(TAG, "PaintingsAdapter: ");
        this.activity= (Activity) context;
        pint.start();
    }
  @Override
  protected ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
    final ViewHolder holder = new ViewHolder(parent);
    holder.image.setOnClickListener(this);
    return holder;
  }
  //这里获取
  @Override
  protected void onBindHolder(ViewHolder holder, int position) {
    final Painting item = getItem(position);
    holder.image.setTag(R.id.list_item_image, item);
    GlideHelper.loadPaintingImage(holder.image, item);
    holder.title.setText(item.getTitle());
  }
  @Override
  public void onClick(View view) {
    final Painting item = (Painting) view.getTag(R.id.list_item_image);
    ActivitysFragment activitysFragment = new ActivitysFragment();
    activitysFragment.openDetails(view, item);
  }

  static class ViewHolder extends ItemsAdapter.ViewHolder {
    final ImageView image;
    final TextView title;
    ViewHolder(ViewGroup parent) {
      super(Views.inflate(parent, R.layout.list_item));
      image = Views.find(itemView, R.id.list_item_image);
      title = Views.find(itemView, R.id.list_item_title);
    }
  }
  public Thread pint = new Thread(new Runnable() {
    @Override
    public void run() {
        String path=activity.getCacheDir().getPath();
        long maxCacheSize = 100 * 1024 * 1024;
        File file=new File(path+"/image_cache");
        OkHttpClient client = new OkHttpClient.Builder().cache(new Cache(file,maxCacheSize)).build();
      Request request = new Request.Builder().url(CREATE_ACCOUNT_URL).build();
      Log.e(TAG, "onCreateView: 2");
      try {
        Response response = client.newCall(request).execute();
          System.out.println("network response = " + response.networkResponse());
          System.out.println("cache response = " + response.cacheResponse());
        if (response.isSuccessful()) {
          String str = null;
          if (response.body() != null) {
            str = response.body().string();
          }
            response.body().close();
          Gson gson = new Gson();
          paintingList = gson.fromJson(str, new TypeToken<List<Painting>>() {}.getType());
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setItemsList(paintingList);
                }
            });
          for (Painting painting : paintingList) {
            Log.e(TAG, "run: " + gson.toJson(painting));
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  });

}
