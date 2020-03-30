package com.rechar.campusassistant.http;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rechar.campusassistant.model.Painting;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WantedCache {
private static final String TAG="WantedCache";
  private String CREATE_ACCOUNT_URL = "https://" + ip + "/WantedServlet";
  private static String ip = "liurechar.utools.club";
  public Thread pint = new Thread(new Runnable() {
    @Override
    public void run() {
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder().url(CREATE_ACCOUNT_URL).build();
      Log.e(TAG, "onCreateView: 2");
      try {
        Log.e(TAG, "onCreateView: 1");
        Response response = client.newCall(request).execute();
        Log.e(TAG, "onCreateView: 3");
        if (response.isSuccessful()) {
          Log.e(TAG, "onCreateView: 4");
          String str = null;
          if (response.body() != null) {
            str = response.body().string();
            Log.e(TAG, "onCreateView:----  " + str);
          }


          Gson gson = new Gson();
          List<Painting> paintingList = gson.fromJson(str, new TypeToken<List<Painting>>() {}.getType());


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
