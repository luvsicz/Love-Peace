package com.rechar.campusassistant.model;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.google.gson.Gson;
import com.rechar.campusassistant.util.HttpImageGetter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * {
 * STATTE:200,
 * DATA:{
 * A:[],
 * B[]
 * }
 * }
 * List<社团> list=request();
 * list[0].url/ingUrl/name/content
 *
 * */
public class Painting implements Serializable {

  private final int id;
  private final String title;
  private final String content;
  private final String url;

  private static final String TAG = "Painting";

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public int getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public Painting(int id, String title, String content, String url) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.url = url;
  }

  public static Painting getAllPaintings(List<Painting> painting) {

    Painting p;
    String title = null;
    String content = null;
    String url = null;
    int id = 0;
    Gson gson = new Gson();

    for (Painting paintings : painting) {
      Log.e(TAG, "run: " + gson.toJson(painting));
      id = paintings.getId();
      title = paintings.getTitle();
      content = paintings.getContent();
      url = paintings.getUrl();
      Drawable img= HttpImageGetter.getDrawable(url);
    }

    p = new Painting(id, title, content, url);

    return p;

      /*  String[] titles =painting.get;
      String[] content = res.getStringArray(R.array.paintings_years);//暂放，从服务端获取
      //  String[] locations = res.getStringArray(R.array.paintings_locations);
        TypedArray images = res.obtainTypedArray(R.array.paintings_images);

        int size = titles.length;
        Painting[] paintings = new Painting[size];
/////获取
        for (int i = 0; i < size; i++) {
            final int imageId = images.getResourceId(i, -1);
            paintings[i] = new Painting(imageId, titles[i],content[i]);
        }

        images.recycle();

       // return paintings;*/
  }
}
